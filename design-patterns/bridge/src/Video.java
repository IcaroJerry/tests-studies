/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class Video extends Media{
    public Video(FormatosDisponiveis formato) {
    super(formato);
  }
 
  @Override
  public void editar() {
    System.out.print(" Arquivo de Video sendo editado e compactado no formato: ");
    formatos.compactar();
   
  }
 

}
