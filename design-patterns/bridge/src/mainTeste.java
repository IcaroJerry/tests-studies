/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class mainTeste {
    public static void main(String[] args) {
 
    Media ft = new Foto(new CompactarToZip());
    ft.editar();
    
   
    
    Media ft2 = new Foto(new CompactarToRAR());
    ft2.editar();
    
    
    Media v = new Video(new CompactarToZip());
    v.editar();
    
    Media v2 = new Video(new CompactarToRAR());
    v2.editar();
    
    
  
 
  }
    
}
 
    

