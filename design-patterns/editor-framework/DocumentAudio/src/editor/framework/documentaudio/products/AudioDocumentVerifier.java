

package editor.framework.documentaudio.products;

import editor.framework.interfaces.abstractyfactory.IDocumentVerifier;


public class AudioDocumentVerifier implements IDocumentVerifier{

    @Override
    public String verifyDocument() {
      return "Implementação completa de "+this.getClass().getSimpleName()+" em construção!";
    }
    
}
