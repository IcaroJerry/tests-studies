/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class Foto extends Media {
    
    public Foto(FormatosDisponiveis formato) {
    super(formato);
  }

   @Override
  public void editar() {
    System.out.print(" Arquivo de Foto sendo editado e compactado no formato: ");
    formatos.compactar();
    
 
  }
 

 
    
}
