

package editor.framework.interfaces.abstractyfactory;

import editor.framework.interfaces.IObservable;
import editor.framework.interfaces.IObserver;
import editor.framework.interfaces.exportBridge.IFormat;
import java.util.List;


public interface  IDocument {
    
    public abstract String openDocument();
    public abstract void exportDocument();
    public abstract String insertDocument();
    
    public abstract void setFormat(IFormat format);
    public abstract IFormat getFormat();
    
    public abstract String nameDocument();
    public abstract void nameDocument(String newName);
    
  
}
