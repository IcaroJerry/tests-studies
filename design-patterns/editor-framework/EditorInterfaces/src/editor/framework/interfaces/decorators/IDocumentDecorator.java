/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.interfaces.decorators;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.exportBridge.IFormat;


/**
 *
 * @author ICAROJ
 */
  public abstract class IDocumentDecorator implements IDocument{

    public IDocumentDecorator(IDocument videodecored)
    {    if(videodecored != null){
         this.documentdecored = videodecored;
         format = this.documentdecored.getFormat();}
    }
     
  
      @Override
    public String openDocument() {
        return  this.documentdecored.openDocument();
    }

    @Override
    public void exportDocument() {
       exportDecored();
    }

    @Override
    public String insertDocument() {
      return this.documentdecored.insertDocument();
    }

    @Override
    public void setFormat(IFormat format) {
       this.format = format;
    }

 
    @Override
    public String nameDocument() {
        return nome;
    }
    
    @Override
    public  void nameDocument(String newName) {
       nome = this.documentdecored.nameDocument()+ " - "  + newName;

    }
    
    @Override
    public IFormat getFormat() {
        return format;
    }
   public abstract void exportDecored();
   public abstract String getName();
   public abstract void setDocument(IDocument doc); 
   
  protected IFormat format;
  protected String nome;
  protected IDocument documentdecored;
}
