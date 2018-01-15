package com.almundo.callcenter;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.Person;
import com.almundo.callcenter.model.TypeEmployee;
import com.almundo.callcenter.view.CallCenterPanel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

/**
 * Clase inicial donde se carga la aplicación.
 * 
 * @author Ruben Ramirez
 */
public class CallCenter {

    private final static Logger logger = LogManager.getLogger(CallCenter.class);
    public static javax.swing.JTextArea txtAreaResult;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CallCenterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CallCenterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CallCenterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CallCenterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//</editor-fold>
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File("log4j2.xml");
        context.setConfigLocation(file.toURI());

        txtAreaResult = new javax.swing.JTextArea();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CallCenterPanel().setVisible(true);
            }
        });
    }

    /**
     * Metodo para configurar Empleados en la aplicacion.
     * 
     * @param numOper numero de operadores a configurar
     * @param numSuper numero de supervisores a configurar
     * @param numDir numero de directores a configurar
     * @return lista de empleados configurados.
     */
    public static List<Employee> getEmployees(int numOper, int numSuper, int numDir) {
        return new ArrayList<Employee>() {
            {
                Person person;

                for (int oper = 1; oper <= numOper; oper++) {
                    person = new Person(oper, "Operador", oper+"A");
                    add(new Employee(oper, person, TypeEmployee.OPERADOR));
                }
                for (int superv = 1; superv <= numSuper; superv++) {
                    person = new Person(superv, "Supervisor", superv+"B");
                    add(new Employee(superv + 100, person, TypeEmployee.SUPERVISOR));
                }
                for (int direc = 1; direc <= numDir; direc++) {
                    person = new Person(direc, "Director", direc+"C");
                    add(new Employee(direc + 1000, person, TypeEmployee.DIRECTOR));
                }
            }
        };
    }

    /**
     * Metodo para configurar llamadas entrantes para la aplicación.
     * 
     * @param numCalls numero de llamadas a simular
     * @return vector de llamadas
     */
    public static Call[] prepareCall(int numCalls) {

        return new ArrayList<Call>() {
            {
                for (int call = 1; call <= numCalls; call++) {
                    add(new Call(call, "Cliente " + call));
                }
            }
        }.toArray(new Call[]{});
    }

}
