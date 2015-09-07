

package editor.framework.documentvideo.products;

import editor.framework.interfaces.abstractyfactory.IDocumentVerifier;


public class VideoDocumentVerifier implements IDocumentVerifier{

    @Override
    public String verifyDocument() {
      return "Implementação completa de "+this.getClass().getSimpleName()+" em construção!";
    }
    
}
