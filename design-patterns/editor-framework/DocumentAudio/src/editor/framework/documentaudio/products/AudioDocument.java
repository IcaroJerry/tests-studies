

package editor.framework.documentaudio.products;


import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.exportBridge.IFormat;


public abstract class AudioDocument implements IDocument{

    @Override
    public IFormat getFormat() {
        return this.format;
    }
    
    
    @Override
    public void setFormat(IFormat format) {
        this.format = format;
    }
           
  
    protected String nome = AudioDocument.class.getSimpleName();
    protected static IFormat format;

}
