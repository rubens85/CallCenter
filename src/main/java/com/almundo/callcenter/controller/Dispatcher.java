package com.almundo.callcenter.controller;

import com.almundo.callcenter.CallCenter;
import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.TypeEmployee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase Dispatcher para atender las llamadas entrantes y asignarlas a los
 * empleados disponibles. Si no hay operadores disponibles las asignará a un
 * supervisor, si no hay supervisor disponible las asignará a un director y si
 * no hay director disponible las colocará en espera para ser atendida por el
 * proximo emppleado disponible.
 *
 * @author Ruben Ramirez
 */
public class Dispatcher {

    //Manejo de los hilos.
    final ExecutorService pool = Executors.newFixedThreadPool(10);
    final ExecutorCompletionService<Call> completionService = new ExecutorCompletionService<>(pool);

    private final static Logger logger = LogManager.getLogger(Dispatcher.class);

    //lista para almacenar las llamadas en espera.
    private List<Call> callQueue;
    private EmployeeController emplContr;

    private String text;
    private final SimpleDateFormat formatDate = new SimpleDateFormat("H:mm:ss");

    private int init;
    private int await;
    private int ended;
    private int resumed;

    public enum CALLS {
        INIT, AWAIT, ENDED, RESUMED
    };
    private final HashMap<CALLS, Integer> callsMap = new HashMap<>();

    public Dispatcher() {
    }

    /**
     * Constructor de la clase donde se asigna el controlador de empleados.
     *
     * @param emplContr controlador del manejo de empleados.
     */
    public Dispatcher(EmployeeController emplContr) {
        callQueue = new ArrayList<>();
        this.emplContr = emplContr;
        initCounters();
    }

    private void initCounters() {
        callsMap.put(CALLS.INIT, init = 0);
        callsMap.put(CALLS.AWAIT, await = 0);
        callsMap.put(CALLS.ENDED, ended = 0);
        callsMap.put(CALLS.RESUMED, resumed = 0);
    }

    /**
     * Metodo para atender la llamada. Este metodo busca un empleado disponible
     * y luego lo asigna a la llamada, la cual es pasada al servicio de hilos
     * para ser ejecutada. Tambien inhabilita al empleado quitandolo de la lista
     * de empleados disponibles. En caso de que no existan empleados disponibles
     * agregará la llamada a una lista de espera.
     *
     * @param call llamada entrante para atender.
     */
    private void dispatchCall(Call call) {
        boolean empleadosNoDispo = true;
        logger.info("Inicia llamada");
        Set<Map.Entry<TypeEmployee, List<Employee>>> entrySet = emplContr.getAvailableEmpl().entrySet();
        for (Map.Entry<TypeEmployee, List<Employee>> listEmpl : entrySet) {
            if (listEmpl.getValue().isEmpty()) {
                empleadosNoDispo = true;
                continue;
            }
            empleadosNoDispo = false;
            Employee nextEmpl = listEmpl.getValue().iterator().next();
            text = "La llamada " + call.getId() + " del Cliente: " + call.getClient() + " es atendida por el " + nextEmpl.getType() + ": " + nextEmpl.getFullName() + " a las " + formatDate.format(new Date());
            callsMap.put(CALLS.INIT, ++init);

            call.setEmployee(nextEmpl);
            logger.info(text);
            CallCenter.txtAreaResult.append(text + "\n");
            completionService.submit(call);
            emplContr.manageEmploy(nextEmpl, EmployeeController.Operation.REMOVE);

            break;
        }

        if (empleadosNoDispo) {
            text = "La llamada: " + call.getId() + " será puesta en espera para ser atendida por el próximo empleado disponible";
            callsMap.put(CALLS.AWAIT, ++await);
            logger.info(text);
            callQueue.add(call);
            CallCenter.txtAreaResult.append(text + "\n");
        }
    }

    /**
     * Metodo para atender 1 ó varias llamadas. Este metodo invoca al metodo
     * dipatchCall(Call) las veces necesarias para atender las llamadas que
     * recibe.
     *
     * Luego de atender las llamadas realiza una peticion al servicio de hilos
     * para saber cuando una llamada finalice y así habilitar nuevamente al
     * empleado. Luego de habilitar al empleado valida si existen llamadas en
     * espera para asignarla a ese empleado disponible y luego invocar
     * nuevamente al metodo dispatch(Call)
     *
     * @param calls Vector de llamadas entrantes.
     * @throws InterruptedException
     */
    public void dispatchCall(Call... calls) throws InterruptedException {
        initCounters();
        for (Call call : calls) {
            dispatchCall(call);
        }
        for (int i = 0; i < calls.length; ++i) {
            final Future<Call> future = completionService.take();
            try {
                final Call callFinish = future.get();
                emplContr.manageEmploy(callFinish.getEmployee(), EmployeeController.Operation.ADD);
                callsMap.put(CALLS.ENDED, ++ended);
                text = "El " + callFinish.getEmployee().getType() + " " + callFinish.getEmployee().getFullName()
                        + " ha finalizado la llamada y ahora se encuentra disponible. "
                        + "Hora de Finalización " + formatDate.format(new Date())
                        + ". Duración de la llamada: " + callFinish.getTime() + " Segundos";
                CallCenter.txtAreaResult.append(text + "\n");
                logger.info(text);

                if (!callQueue.isEmpty()) {
                    Call call = callQueue.remove(0);
                    callsMap.put(CALLS.RESUMED, ++resumed);
                    this.dispatchCall(call);
                }
            } catch (ExecutionException e) {
            }
        }

    }

    //Retorna map con el resultado del procesamiento de las llamadas.
    public HashMap<CALLS, Integer> getCallsMap() {
        return callsMap;
    }

}
