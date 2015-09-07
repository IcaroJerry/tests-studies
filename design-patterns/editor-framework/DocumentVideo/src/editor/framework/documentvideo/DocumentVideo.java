
package editor.framework.documentvideo;

import editor.framework.menuoptionvideo.windowOption.CommandController;
import editor.framework.documentvideo.products.VideoDocument;
import editor.framework.documentvideo.products.VideoDocumentSimple;
import editor.framework.documentvideo.products.VideoDocumentVerifier;
import editor.framework.documentvideo.products.VideoEffects;
import editor.framework.documentvideo.products.VideoHelp;
import editor.framework.effectsvideo.EffectsVideoIcaroJ;
import editor.framework.exportersvideo.ExporterVideo;
import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IDocumentVerifier;
import editor.framework.interfaces.abstractyfactory.IEditorAbstractFactory;
import editor.framework.interfaces.abstractyfactory.IEffectsEditor;
import editor.framework.interfaces.abstractyfactory.IHelpEditor;
import editor.framework.menuoptionvideo.MenuOptionVideo;
import editor.framework.menuplay.MenuPlay;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class DocumentVideo  extends IEditorAbstractFactory  implements IPlugin{
 
     public final void registerObserverVideo()
     {
         ICore.getInstance().getProjectController().registerObserver(new MenuPlay());
         ICore.getInstance().getProjectController().registerObserver(new MenuOptionVideo());
         registerMoreObserverVideo();
     }
     
     protected void registerMoreObserverVideo()
     {
     
     }
     
     
    @Override
    public IDocument CreateDocument() {
      return new VideoDocumentSimple();
    }

    @Override
    public IDocumentVerifier CreateDocumentVerifier() {
       return new VideoDocumentVerifier();
    }

    @Override
    public IHelpEditor CreateHelpEditor() {
       return new VideoHelp();
    }
    
    @Override
    public IEffectsEditor CreateEffectsEditor(){
       return new VideoEffects();
    }
    
 @Override
    public void initialize() {
        
       System.out.println("Initializing plugin: " + DocumentVideo.class.getSimpleName());
    
        JMenu menuTexto = new JMenu("New");
        JMenuItem newMenuItem = new JMenuItem("Video");
        menuTexto.add(newMenuItem);
        
        ICore.getInstance().getUiController().addMenuItem("File", menuTexto);
       
            newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });    
      registerObserverVideo();
    }

      
     private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            instance =  new DocumentVideo();
            IDocument document = instance.CreateDocument();
            ICore.getInstance().getProjectController().setCurrentDocument(document);
            ICore.getInstance().getProjectController().setCurrentExports(new ExporterVideo());
            ICore.getInstance().getProjectController().setComponent(new EffectsVideoIcaroJ());    
            JOptionPane.showMessageDialog(null, "Editor Framework! Editando Video!", document.openDocument(), JOptionPane.INFORMATION_MESSAGE);
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Video não pode ser criada!" + ICore.getInstance().getProjectController().getCurrentDoucment());
          }
        
         
     }
}