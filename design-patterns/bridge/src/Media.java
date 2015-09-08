/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public abstract class Media {
  protected FormatosDisponiveis formatos;
 
 
  protected Media(FormatosDisponiveis formato) {
    this.formatos = formato;
    
  }
 
  abstract public void editar();
  
}
    

