/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menuinsert;

import editor.framework.interfaces.*;
import editor.framework.interfaces.abstractyfactory.IDocument;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author ICAROJ
 */
public class MenuInsert implements IPlugin {

    @Override
    public void initialize() {
        System.out.println("Initializing plugin: "+ MenuInsert.class.getSimpleName());
        
        JMenuItem newItem = ICore.getInstance().getUiController().addMenuItem("Edit", new javax.swing.JMenuItem("Insert"));
          
        if (newItem != null) {
            newItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
    
        }
    }
    
        private void newItemActionPerformed(java.awt.event.ActionEvent evt)  {                                       
                        
          try{
             IDocument document = ICore.getInstance().getProjectController().getCurrentDoucment();
            JOptionPane.showMessageDialog(null, document.insertDocument());
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Nenhum documento foi criado ainda!");
          }
        }
    
}