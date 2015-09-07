/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.documentvideo.products;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.abstractyfactory.IEditorAbstractFactory;
import editor.framework.interfaces.exportBridge.IFormat;


/**
 *
 * @author ICAROJ
 */
public class VideoComposite extends VideoDocumentSimple{



    @Override
    public void exportDocument() {
         System.out.println("Exportando um grupo de:" + VideoDocumentSimple.class.getSimpleName());
         for(int i = 0 ; i < components.size(); i++){
             IDocument docs =  components.get(i);
             System.out.println("# " + VideoComposite.class.getSimpleName()+ " - " + i);
             docs.exportDocument();       
         }
    }

    
     public void addComponent(IDocument component)
     {
            components.add(component);
     }
     
     public void removeComponent(){
         components.remove(components.size() - 1);
     }
     
     @Override
     public String insertDocument() {
         VideoDocumentSimple temp = new VideoDocumentSimple();
         addComponent(temp);
         return "Video: " + nameDocument() + " inserida!";
     }
     
      @Override
    public String nameDocument() {
        return nome +" - "+ components.size();
    }
    
    public VideoComposite(IDocument doc, IFormat frt)
    {   
        components = new java.util.ArrayList<IDocument>(); 
        addComponent(doc);
        format = frt;
    } 
    
    private static java.util.List<IDocument> components;

   
}
