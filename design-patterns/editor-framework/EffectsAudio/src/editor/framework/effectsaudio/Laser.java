/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.effectsaudio;



import editor.framework.interfaces.ICore;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.decorators.IDocumentDecorator;
import editor.framework.interfaces.exportBridge.IFormat;


/**
 *
 * @author ICAROJ
 */
public class Laser extends IDocumentDecorator{

  
    public Laser(IDocument imagedecored) {
        super(imagedecored);
        this.nameDocument(this.getName());
    }
    
    public Laser() {
       super(null);
    }

    @Override
    public String getName() {
      return Laser.class.getSimpleName();
    }
   
    @Override
    public void setDocument(IDocument doc) {
        ICore.getInstance().getProjectController().setCurrentDocument((IDocument)new Laser(doc));

    
    }

    @Override
    public void exportDecored() {
        String temp;
         temp = "Exportando: " + nameDocument() + "."+ this.getFormat().getFormat();
        System.out.println(temp);   
    }
}
