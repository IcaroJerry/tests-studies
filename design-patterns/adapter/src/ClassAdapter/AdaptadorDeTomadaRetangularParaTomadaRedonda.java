/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassAdapter;

/**
 *
 * @author BRUNO
 */
public class AdaptadorDeTomadaRetangularParaTomadaRedonda extends TomadaRedonda{
  public String adapt(String plugRetangular1, String plugRetangular2) {
    //some conversion logic
    String plugRedondo1 = plugRetangular1;
    String plugRedondo2 = plugRetangular2;
    return fornecerEnergia(plugRedondo1, plugRedondo2);
  }
}