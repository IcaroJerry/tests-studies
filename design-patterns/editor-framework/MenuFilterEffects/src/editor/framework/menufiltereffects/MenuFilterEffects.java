/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menufiltereffects;

import editor.framework.menufiltereffects.gui.ScreenEffects;
import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IEditorAbstractFactory;
import editor.framework.interfaces.abstractyfactory.IEffectsEditor;
import javax.swing.*;

/**
 *
 * @author ICAROJ
 */
public class MenuFilterEffects implements IPlugin{

    @Override
    public void initialize() {
        System.out.println("Initializing plugin: EditorDecorator");
    
        JMenuItem newItem = ICore.getInstance().getUiController().addMenuItem("Edit", new javax.swing.JMenuItem("Filter Effects"));
          
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
             {JFrame window = new ScreenEffects(document);
                ICore.getInstance().getUiController().showWindow(window, true);}
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Nenhum documento foi criado!");
          }
        }
        
}
