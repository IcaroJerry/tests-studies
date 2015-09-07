
package editor.framework.documentaudio;

import editor.framework.documentaudio.products.AudioDocumentSimple;
import editor.framework.documentaudio.products.AudioDocumentVerifier;
import editor.framework.documentaudio.products.AudioEffects;
import editor.framework.documentaudio.products.AudioHelp;
import editor.framework.effectsaudio.EffectsAudioIcaroJ;
import editor.framework.exportersaudio.ExporterAudio;
import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IDocumentVerifier;
import editor.framework.interfaces.abstractyfactory.IEditorAbstractFactory;
import editor.framework.interfaces.abstractyfactory.IEffectsEditor;
import editor.framework.interfaces.abstractyfactory.IHelpEditor;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class DocumentAudio  extends IEditorAbstractFactory  implements IPlugin{

    @Override
    public IDocument CreateDocument() {
      return new AudioDocumentSimple();
    }

    @Override
    public IDocumentVerifier CreateDocumentVerifier() {
       return new AudioDocumentVerifier();
    }

    @Override
    public IHelpEditor CreateHelpEditor() {
       return new AudioHelp();
    }
    
    @Override
    public IEffectsEditor CreateEffectsEditor(){
       return new AudioEffects();
    }
    
 @Override
    public void initialize() {
        
       System.out.println("Initializing plugin: " + DocumentAudio.class.getSimpleName());
    
        JMenu menuTexto = new JMenu("New");
        JMenuItem newMenuItem = new JMenuItem("Audio");
        menuTexto.add(newMenuItem);
        
        ICore.getInstance().getUiController().addMenuItem("File", menuTexto);
       
        if (newMenuItem != null) {
            newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        }
    }

    
     private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            instance =  new DocumentAudio();
            IDocument document = instance.CreateDocument();
            ICore.getInstance().getProjectController().setCurrentDocument(document);
            ICore.getInstance().getProjectController().setCurrentExports(new ExporterAudio());
            ICore.getInstance().getProjectController().setComponent(new EffectsAudioIcaroJ());
            JOptionPane.showMessageDialog(null, "Editor Framework! Editando Audio!", document.openDocument(), JOptionPane.INFORMATION_MESSAGE);
          }
          
          catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Audio não pode ser criado!" + ICore.getInstance().getProjectController().getCurrentDoucment());
          }
        
         
     }
   
}