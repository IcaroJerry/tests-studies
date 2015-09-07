

package editor.framework.documentaudio.products;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.exportBridge.IFormat;


public class AudioDocumentSimple extends AudioDocument{


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
        ICore.getInstance().getProjectController().setCurrentDocument(new AudioComposite(this, format));
        return "Audio: " + nameDocument() + " - inserido!";
    }

   

    @Override
    public void nameDocument(String newName) {
       nome = newName;
    }


}