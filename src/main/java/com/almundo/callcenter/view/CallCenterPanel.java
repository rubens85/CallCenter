/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.view;

import com.almundo.callcenter.CallCenter;
import com.almundo.callcenter.controller.Dispatcher;
import com.almundo.callcenter.controller.EmployeeController;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rdramirez
 */
public class CallCenterPanel extends javax.swing.JFrame {

    private EmployeeController employeeController = null;
    private Dispatcher dispatcher = null;

    /**
     * Creates new form CallCenterPanel
     */
    public CallCenterPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblNumOper = new javax.swing.JLabel();
        lblNumSuper = new javax.swing.JLabel();
        lblNumDirec = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumOper = new javax.swing.JTextField();
        txtNumSuper = new javax.swing.JTextField();
        txtNumDirec = new javax.swing.JTextField();
        lblNumCalls = new javax.swing.JLabel();
        txtNumCalls = new javax.swing.JTextField();
        btnInitCalls = new javax.swing.JButton();
        btnLoadEmpl = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaResult = CallCenter.txtAreaResult;
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSummary = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNumOper.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumOper.setText("Número de Operadores");

        lblNumSuper.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumSuper.setText("Número de Supervisores");

        lblNumDirec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumDirec.setText("Número de Directores");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setText("CALL CENTER");

        txtNumOper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumOper.setText("5");

        txtNumSuper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumSuper.setText("2");

        txtNumDirec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumDirec.setText("1");

        lblNumCalls.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumCalls.setText("Número de Llamadas");

        txtNumCalls.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumCalls.setText("10");

        btnInitCalls.setText("Iniciar Llamadas");
        btnInitCalls.setEnabled(false);
        btnInitCalls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitCallsActionPerformed(evt);
            }
        });

        btnLoadEmpl.setText("Cargar Empleados");
        btnLoadEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadEmplActionPerformed(evt);
            }
        });

        txtAreaResult.setEditable(false);
        txtAreaResult.setColumns(20);
        txtAreaResult.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtAreaResult.setRows(5);
        jScrollPane1.setViewportView(txtAreaResult);

        txtAreaSummary.setEditable(false);
        txtAreaSummary.setColumns(20);
        txtAreaSummary.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtAreaSummary.setRows(5);
        jScrollPane2.setViewportView(txtAreaSummary);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Registro de Llamadas");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Resumen");

        btnClear.setText("Limpiar Registros");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumOper)
                            .addComponent(lblNumCalls))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumOper, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumCalls, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInitCalls)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNumSuper)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNumDirec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnLoadEmpl)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumOper)
                    .addComponent(txtNumOper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumSuper)
                    .addComponent(txtNumSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumDirec)
                    .addComponent(txtNumDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadEmpl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCalls)
                    .addComponent(txtNumCalls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInitCalls)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInitCallsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitCallsActionPerformed
        try {
            txtAreaResult.setText("");
        txtAreaSummary.setText("");
            
            if (dispatcher == null) {
                dispatcher = new Dispatcher(employeeController);
            }
            dispatcher.dispatchCall(CallCenter.prepareCall(this.getNumber(txtNumCalls)));

            Set<Map.Entry<Dispatcher.CALLS, Integer>> resultCalls = dispatcher.getCallsMap().entrySet();

            this.txtAreaSummary.setText("Llamadas Entrantes: ");
            this.txtAreaSummary.append(dispatcher.getCallsMap().get(Dispatcher.CALLS.INIT) + "\n");
            this.txtAreaSummary.append("Llamadas Finalizadas: ");
            this.txtAreaSummary.append(dispatcher.getCallsMap().get(Dispatcher.CALLS.ENDED) + "\n");
            this.txtAreaSummary.append("Llamadas en Espera: ");
            this.txtAreaSummary.append(dispatcher.getCallsMap().get(Dispatcher.CALLS.AWAIT) + "\n");
            this.txtAreaSummary.append("Llamadas en Esperas Atendidas: ");
            this.txtAreaSummary.append(dispatcher.getCallsMap().get(Dispatcher.CALLS.RESUMED).toString());

        } catch (InterruptedException ex) {

        }

    }//GEN-LAST:event_btnInitCallsActionPerformed

    private void btnLoadEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadEmplActionPerformed
        if (employeeController == null) {
            employeeController = new EmployeeController(CallCenter.getEmployees(this.getNumber(txtNumOper), this.getNumber(txtNumSuper), this.getNumber(txtNumDirec)));
            btnLoadEmpl.setEnabled(false);
            btnInitCalls.setEnabled(true);
        }
    }//GEN-LAST:event_btnLoadEmplActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        employeeController = null;
        dispatcher = null;
        btnLoadEmpl.setEnabled(true);
        btnInitCalls.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private int getNumber(javax.swing.JTextField textField) {
        try {
            return Integer.parseInt(textField.getText().isEmpty() ? "0" : textField.getText());
        } catch(NumberFormatException nfe) {
            return 0;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnInitCalls;
    private javax.swing.JButton btnLoadEmpl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNumCalls;
    private javax.swing.JLabel lblNumDirec;
    private javax.swing.JLabel lblNumOper;
    private javax.swing.JLabel lblNumSuper;
    private javax.swing.JTextArea txtAreaResult;
    private javax.swing.JTextArea txtAreaSummary;
    private javax.swing.JTextField txtNumCalls;
    private javax.swing.JTextField txtNumDirec;
    private javax.swing.JTextField txtNumOper;
    private javax.swing.JTextField txtNumSuper;
    // End of variables declaration//GEN-END:variables
}
