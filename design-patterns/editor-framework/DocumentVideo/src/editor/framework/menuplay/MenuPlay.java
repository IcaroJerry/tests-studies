package editor.framework.menuplay;


import editor.framework.documentvideo.products.VideoDocument;
import editor.framework.menuoptionvideo.*;
import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IObserver;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.menuoptionvideo.windowOption.VideoOption;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ICAROJ
 */
public class MenuPlay  implements IObserver
{
    @Override
    public void update(Object obj) {
      if(obj instanceof VideoDocument)
         registerMenu();
      else
         undoRegisterMenu();
      
    System.out.println("Menu: "+ MenuPlay.class.getSimpleName() +" loaded! MenuPlay is "+ menuPlay.isVisible());
    }
  
    
    
    public MenuPlay()
    {
        if(menuPlay == null)
        {    menuPlay  = new JMenuItem("Play");
             menuPlay.setVisible(true);
        }
    }
    
    public void visible(boolean visible)
    {   
      menuPlay.setVisible(visible);
      ICore.getInstance().getUiController().repaintWindow();
    }
    
   /* public boolean verifyDocumentCurrent()
    {
        return ICore.getInstance().getProjectController().getCurrentDoucment() instanceof DocumentVideo;
    }*/
   
    private void registerMenu(){
      ICore.getInstance().getUiController().addMenuItem("File", menuPlay);
            menuPlay.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
         visible(true);
    }
    
     private void undoRegisterMenu(){
        ICore.getInstance().getUiController().removeMenu(menuPlay);   
        visible(false);
    }

   private void newItemActionPerformed(java.awt.event.ActionEvent evt)  {                                       
                        
          try{
             ((VideoDocument) ICore.getInstance().getProjectController().getCurrentDoucment()).executeVideo();
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Erro ao executar video");
          }
        }

    private static JMenuItem menuPlay;
}
