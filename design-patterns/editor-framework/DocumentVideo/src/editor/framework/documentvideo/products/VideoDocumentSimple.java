

package editor.framework.documentvideo.products;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.exportBridge.IFormat;


public class VideoDocumentSimple extends VideoDocument{


    @Override
    public String openDocument() {
        return "Abrindo "+ nameDocument() +"!";
    }

    @Override
    public void exportDocument() {
      System.out.println("Exportando: " + nameDocument() + "."+format.getFormat());   
    }

    @Override
    public String nameDocument() {
        return nome;
    }

    @Override
    public String insertDocument() {
        ICore.getInstance().getProjectController().setCurrentDocument(new VideoComposite(this, format));
        return "Video: " + nameDocument() + " - inserida!";
    }

   

    @Override
    public void nameDocument(String newName) {
       nome = newName;
    }

  
    
}