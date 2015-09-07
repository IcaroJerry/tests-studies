

package editor.framework.interfaces;

import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IEditorAbstractFactory;
import editor.framework.interfaces.decorators.IComponent;
import editor.framework.interfaces.exportBridge.IExporters;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;


public abstract class IProjectController implements IObservable{
    
    public IProjectController()
    {
        observers = new ArrayList<>();
    }
    
    public abstract IComponent getComponent();
    public abstract void setComponent(IComponent component);
    
    public abstract IEditorAbstractFactory getFactory();
    
    public abstract IDocument getCurrentDoucment();
    public abstract void setCurrentDocument(IDocument currentFactory);
    
    public abstract void setCurrentExports(IExporters current);
    public abstract IExporters getCurrentExports();
     
    public abstract void addNameActivePlugin(String name);
    public abstract List<String> allActivePlugin();
    public abstract List<IPlugin> pluginsByType(Object type);
    public abstract void setDataJars(URLClassLoader dataJars);
    
     
    @Override
    public void registerObserver(IObserver observer){
        observers.add(observer);
        System.out.println("System: observer  "+observer.getClass().getSimpleName()+
                            " was registered for "+ IDocument.class.getSimpleName());
    }
    
    @Override
    public void removeObserver(IObserver obj){
        observers.remove(obj);
    }
    
    @Override
    public void notifyAllObserver()
    {
        for(IObserver ob : observers){
            ob.update(getCurrentDoucment());
        }
    }
    
    protected List<IObserver> observers;
}
