package editor.framework.menuoptionvideo;


import editor.framework.interfaces.ICore;
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
public class MenuOptionVideo implements IPlugin{

    @Override
    public void initialize(){
        visible(false);
        System.out.println("Lib: "+ MenuOptionVideo.class.getSimpleName() +" loaded! VideoMenuOption"+ menuOption.isVisible());
    }
    
    public MenuOptionVideo()
    {
        if(menuOption == null)
        {    menuOption  = new JMenuItem("Video");
             menuOption.setVisible(true);
        }
        
        if(window == null)
        {
            window = new VideoOption();
            window.setVisible(false);
        }
    }
    
    public void visible(boolean visible)
    {   
      menuOption.setVisible(visible);
      //ICore.getInstance().getUiController().refreshPlugins();
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
    }
    
    
        private void newItemActionPerformed(java.awt.event.ActionEvent evt)  {                                       
                        
          try{
             IDocument document = ICore.getInstance().getProjectController().getCurrentDoucment();
             window.setVisible(true);
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Nenhum documento foi criado ainda!");
          }
        }
    
    private static JMenuItem menuOption;
    private static VideoOption window;
}
