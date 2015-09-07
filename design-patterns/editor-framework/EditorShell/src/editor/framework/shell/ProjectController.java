

package editor.framework.shell;

import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.IProjectController;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IEditorAbstractFactory;
import editor.framework.interfaces.decorators.IComponent;
import editor.framework.interfaces.exportBridge.IExporters;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProjectController extends IProjectController {
     
     public ProjectController() {
      nameActivePlugins = new ArrayList<>();
     }
     
  
     @Override
     public IEditorAbstractFactory getFactory()
     {   
        return IEditorAbstractFactory.getInstance();
     }
    
     @Override
     public void setCurrentDocument(IDocument currentDocument)
     {
        CURRENT_DOCUMENT = currentDocument;
        notifyAllObserver();
     }
  
     @Override
     public IDocument getCurrentDoucment()
     {   
        return  CURRENT_DOCUMENT;
     }
    
     
      @Override
    public void setCurrentExports(IExporters current) {
       CURRENT_EXPORTER = current;
    }
    
     @Override
    public IExporters getCurrentExports() {
       return CURRENT_EXPORTER;
    }
    
     @Override
     public void addNameActivePlugin(String name)
     {
        nameActivePlugins.add(name);
     }     
     
     @Override
     public List<String> allActivePlugin()
     {
         return nameActivePlugins;
     }
    
     @Override
     public  IComponent getComponent() {
        return CURRENT_COMPONENT;
    }

     @Override
    public  void setComponent(IComponent component) {
        CURRENT_COMPONENT = component;
    }

     @Override
    public List<IPlugin> pluginsByType(Object type)
    {
        List<String> pluginsNames = this.allActivePlugin();
        List<IPlugin> plugins = new ArrayList<>();
        
        for(int i = 0; i < pluginsNames.size(); i++)
        { 
         IPlugin temp = null; 
            try {
                     temp  = (IPlugin) Class.forName(pluginsNames.get(i),true, dataJars).newInstance();
                       
            
                    if(type.getClass().isInstance(temp))
                       plugins.add(temp);
             } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        return plugins;
    }
    
    public void setDataJars(URLClassLoader dataJars) {
        this.dataJars = dataJars;
    }
 
   private  List<String> nameActivePlugins;
   private URLClassLoader dataJars;
   private static IDocument  CURRENT_DOCUMENT;
   private static IExporters  CURRENT_EXPORTER;
   private static IComponent  CURRENT_COMPONENT;
//   private static Object backEndExport;

   
  
}
