package oazidea.client;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UiClient extends javax.swing.JFrame {

    public UiClient() {
        initComponents();
        uiConfigServer = new UiConfigServer();
        uiConfigServer.setVisible(false);
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChatArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessageArea = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_connect = new javax.swing.JMenu();
        mConnect = new javax.swing.JMenuItem();
        mDisconnect = new javax.swing.JMenuItem();
        jm_config = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtChatArea.setEditable(false);
        txtChatArea.setColumns(20);
        txtChatArea.setRows(5);
        jScrollPane1.setViewportView(txtChatArea);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Galera On"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        txtMessageArea.setColumns(20);
        txtMessageArea.setRows(5);
        jScrollPane3.setViewportView(txtMessageArea);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jm_connect.setText("Connect");

        mConnect.setText("Connect");
        mConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConnectActionPerformed(evt);
            }
        });
        jm_connect.add(mConnect);

        mDisconnect.setText("Disconnect");
        mDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDisconnectActionPerformed(evt);
            }
        });
        jm_connect.add(mDisconnect);

        jMenuBar1.add(jm_connect);

        jm_config.setText("Config");

        jMenuItem1.setText("Connection...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jm_config.add(jMenuItem1);

        jMenuBar1.add(jm_config);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSend))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void appendMessages(String m){
        txtChatArea.append(m+"\n");
    }
    public void clearFields(){
        txtChatArea.setText("");
        txtMessageArea.setText("");
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(!uiConfigServer.isVisible())
            uiConfigServer.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConnectActionPerformed
        OaZideaClient.getInstance().connectToServer();
    }//GEN-LAST:event_mConnectActionPerformed

    private void mDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDisconnectActionPerformed
        OaZideaClient.getInstance().disconnectFromServer();
    }//GEN-LAST:event_mDisconnectActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            OaZideaClient.getInstance().sendMessage();
            clearMessageArea();
        } catch (RemoteException ex) {
            Logger.getLogger(UiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    public String getMessage(){
        return this.txtMessageArea.getText();
    }
    
    public void clearMessageArea(){
        this.txtMessageArea.setText("");
    }
    private UiConfigServer uiConfigServer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu jm_config;
    private javax.swing.JMenu jm_connect;
    private javax.swing.JMenuItem mConnect;
    private javax.swing.JMenuItem mDisconnect;
    private javax.swing.JTextArea txtChatArea;
    private javax.swing.JTextArea txtMessageArea;
    // End of variables declaration//GEN-END:variables
}
