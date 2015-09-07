/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menuexport;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.menuexport.gui.ScreenExport;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author ICAROJ
 */
public class MenuExport implements IPlugin{

  @Override
    public void initialize() {
        System.out.println("Initializing plugin: ExportEditor");
    
        JMenuItem newItem = ICore.getInstance().getUiController().addMenuItem("File", new javax.swing.JMenuItem("Export..."));
          
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
             if(document != null)
              ICore.getInstance().getUiController().showWindow(new ScreenExport(document), Boolean.TRUE);
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Nenhum documento foi criado!");
          }
          
        
        }
  
}
