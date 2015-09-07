
package editor.framework.menuexport.gui;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.exportBridge.IExporters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author ICAROJ
 */
public class ScreenExport extends JFrame {

    //    public void loadFormart(){
    //    ICore.getInstance().getProjectController().pluginsByType(null);
    //    }
    //    
    public void loadFormart()
    {   
        IExporters tempExporters =  ICore.getInstance().getProjectController().getCurrentExports();
        List<String> tempFormart = tempExporters.getNamesFormat();
       
        List<JRadioButton> options = new ArrayList<>();
        for(int i = 0; i < tempFormart.size(); i++)
        {  Boolean ini = false;  
           if(i == 0) ini = true;
           options.add(new JRadioButton(tempFormart.get(i), ini));
        }
        
        ButtonGroup groupTemp = new ButtonGroup();
         for(int i = 0; i < options.size(); i++)
        {  
            groupTemp.add(options.get(i));
        }
        this.groupBackEnd =  groupTemp;
       
      
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(2, options.size()/2));
        for(int i = 0; i < options.size(); i++)
        {  
            radioPanel.add(options.get(i));
        }
    
       
        radioPanel.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "FORMATS FOR EXPORT DOCUMENT"));
        radioPanel.setVisible(true);
             
        this.add(radioPanel);
        this.setLayout(radioPanel.getLayout());
        this.repaint();  
        this.revalidate();   
    }
    
    public ScreenExport(IDocument doc) {
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

        groupBackEnd = new javax.swing.ButtonGroup();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
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
                .addGap(97, 97, 97)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
           Enumeration<AbstractButton> tempList = this.groupBackEnd.getElements();
           String tempName = null;
          
           for(int i = 0 ; i< this.groupBackEnd.getButtonCount(); i++)
           {
                AbstractButton temp = tempList.nextElement();
                if(temp.isSelected())
                {
                    tempName = temp.getText();break;
                }
           }
         
           try{
           document.setFormat(ICore.getInstance().getProjectController().getCurrentExports().getFormat(tempName));
           document.exportDocument();
           JOptionPane.showMessageDialog(null, document.nameDocument()+" - exportado!");
           
           
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao exportar!");
           }
           this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(ScreenExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenExport(ICore.getInstance().getProjectController().getCurrentDoucment()).setVisible(true);
            }
        });
    }
    

    private IDocument document;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup groupBackEnd;
    // End of variables declaration//GEN-END:variables

}
