package editor.framework.menuoptionvideo;


import editor.framework.documentvideo.products.VideoDocument;
import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IObserver;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.menuoptionvideo.windowOption.VideoOption;
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
public class MenuOptionVideo implements IObserver
{  
    @Override
    public void update(Object obj) {
      if(obj instanceof VideoDocument)
        registerMenu();
      else
          undoRegisterMenu();
      System.out.println("Menu: "+ MenuOptionVideo.class.getSimpleName() +" loaded! VideoMenuOption is"+ menuOption.isVisible());
    }
    
    public MenuOptionVideo()
    {
        if(menuOption == null)
        {    menuOption  = new JMenuItem("Video");
             menuOption.setVisible(true);
        }
    }
    
    public void visible(boolean visible)
    {   
      menuOption.setVisible(visible);
      ICore.getInstance().getUiController().repaintWindow();
      ICore.getInstance().getUiController().repaintWindow();
    }
    
   /* public boolean verifyDocumentCurrent()
    {
        return ICore.getInstance().getProjectController().getCurrentDoucment() instanceof DocumentVideo;
    }*/
   
    public void registerMenu(){
        
        ICore.getInstance().getUiController().addMenuItem("Option", menuOption);
            menuOption.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
              
            window = new VideoOption();
            window.setVisible(false);
            visible(true);
    }
    
    public void undoRegisterMenu(){
        ICore.getInstance().getUiController().removeMenu(menuOption);   
        visible(false);
    }
    
    
        private void newItemActionPerformed(java.awt.event.ActionEvent evt)  {                                       
                        
          try{
               window.verifyOption();
               window.setVisible(true);
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Nenhum documento foi criado ainda!");
          }
        }
    
    private static JMenuItem menuOption;
    private static VideoOption window;
}
