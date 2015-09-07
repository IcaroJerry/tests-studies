/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menufiltereffects.gui;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IEffectsEditor;
import editor.framework.interfaces.decorators.IComponent;
import editor.framework.interfaces.decorators.IDocumentDecorator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ICAROJ
 */
public class ScreenEffects extends javax.swing.JFrame {

    public void loadFormart()
    {
        IComponent dataComponett =  ICore.getInstance().getProjectController().getComponent();
        List<String> tempDecorators = dataComponett.getNamesDecorators();
        DefaultTableModel modelTemp = (DefaultTableModel)this.tableListDecorators.getModel();
        for(int i = 0; i < tempDecorators.size(); i++)
        {   
            modelTemp.insertRow(i, new String[]{"Nome"});
            modelTemp.setValueAt(tempDecorators.get(i).toString(),i,0);
        }
    }
    
    public ScreenEffects(IDocument doc) {
        initComponents();
        if(doc != null)
        {
         loadFormart();
         this.document = doc;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableListDecorators = new javax.swing.JTable();
        insertOne = new javax.swing.JButton();
        removeAll = new javax.swing.JButton();
        insertAll = new javax.swing.JButton();
        removeOne = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDecorators = new javax.swing.JTable();
        btnApply = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableListDecorators.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Efeitos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableListDecorators.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableListDecorators);
        if (tableListDecorators.getColumnModel().getColumnCount() > 0) {
            tableListDecorators.getColumnModel().getColumn(0).setResizable(false);
        }

        insertOne.setText(">");
        insertOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertOneActionPerformed(evt);
            }
        });

        removeAll.setText("<<");
        removeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllActionPerformed(evt);
            }
        });

        insertAll.setText(">>");
        insertAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAllActionPerformed(evt);
            }
        });

        removeOne.setText("<");
        removeOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOneActionPerformed(evt);
            }
        });

        tableDecorators.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Efeitos Aplicados"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDecorators.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableDecorators);
        tableDecorators.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tableDecorators.getColumnModel().getColumnCount() > 0) {
            tableDecorators.getColumnModel().getColumn(0).setResizable(false);
        }

        btnApply.setText("Aplicar");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insertOne, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeOne, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertAll, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeAll, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnApply)
                        .addGap(121, 121, 121)
                        .addComponent(btnCancel)))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(insertOne)
                        .addGap(6, 6, 6)
                        .addComponent(removeOne)
                        .addGap(31, 31, 31)
                        .addComponent(insertAll)
                        .addGap(6, 6, 6)
                        .addComponent(removeAll))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApply)
                    .addComponent(btnCancel))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertOneActionPerformed

        DefaultTableModel modelTemp = (DefaultTableModel)this.tableDecorators.getModel();
        int[] index = this.tableListDecorators.getSelectedRows();
        String[] nameEffect = new String[index.length];
        
        for(int i = 0; i < index.length; i++)
        {
          nameEffect[i] =  this.tableListDecorators.getValueAt(index[i], 0).toString();
          modelTemp.addRow(nameEffect);
          //modelTemp.setValueAt( nameEffect[i], modelTemp.getRowCount()-1,0);
        }

        this.tableDecorators.setModel(modelTemp);
    }//GEN-LAST:event_insertOneActionPerformed

    private void removeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllActionPerformed

        DefaultTableModel modelTemp = (DefaultTableModel)this.tableDecorators.getModel();
        int allEffects = modelTemp.getRowCount();

        for(int i = 0; i < allEffects; i++)
        {
            modelTemp.removeRow((allEffects - i)-1 );
        }

        this.tableDecorators.setModel(modelTemp);
    }//GEN-LAST:event_removeAllActionPerformed

    private void insertAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAllActionPerformed
        DefaultTableModel modelTemp = (DefaultTableModel)this.tableDecorators.getModel();
        int rowsTable = modelTemp.getRowCount();
        int allEffects = this.tableListDecorators.getRowCount();
        String[] nameEffect = null;
        int aux = 0;
        
        for(int i = rowsTable; i < rowsTable+allEffects; i++)
        {
            nameEffect = new String[allEffects];
            modelTemp.addRow(nameEffect);
            modelTemp.setValueAt( this.tableListDecorators.getValueAt(aux, 0).toString(),i,0);
            aux++;
        }

        this.tableDecorators.setModel(modelTemp);
    }//GEN-LAST:event_insertAllActionPerformed

    private void removeOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOneActionPerformed

     

    }//GEN-LAST:event_removeOneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
       List<String> tempDecorators = new ArrayList<>();
       DefaultTableModel modelTemp = (DefaultTableModel)this.tableDecorators.getModel();
        for(int i = 0; i < tableDecorators.getRowCount(); i++)
        { 
           tempDecorators.add(modelTemp.getValueAt(i, 0).toString());
        }
        try{
        
            for(int i = 0; i < tempDecorators.size(); i++)
            { 
              ICore.getInstance().getProjectController().getComponent()
                                   .applyEffects(tempDecorators.get(i),document);
             document = ICore.getInstance().getProjectController().getCurrentDoucment();
             }
            JOptionPane.showMessageDialog(null, document.nameDocument()+" - com efeito!");
            this.dispose();
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao aplicar os efeitos!");
           }
           this.dispose();
    }//GEN-LAST:event_btnApplyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ScreenEffects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenEffects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenEffects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenEffects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenEffects(ICore.getInstance().getProjectController().getCurrentDoucment()).setVisible(true);
            }
        });
    }
    
    private  IDocument document;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton insertAll;
    private javax.swing.JButton insertOne;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeAll;
    private javax.swing.JButton removeOne;
    private javax.swing.JTable tableDecorators;
    private javax.swing.JTable tableListDecorators;
    // End of variables declaration//GEN-END:variables
}
