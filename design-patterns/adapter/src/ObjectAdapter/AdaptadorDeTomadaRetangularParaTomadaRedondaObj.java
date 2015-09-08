/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectAdapter;

/**
 *
 * @author BRUNO
 */
public class AdaptadorDeTomadaRetangularParaTomadaRedondaObj {
private TomadaRedondaObj socket;
 
  public String adapt(String plugRetangular1, String plugRetangular2) {
    //some conversion logic
    socket = new TomadaRedondaObj();
    String plugRedondo1 = plugRetangular1;
    String plugRedondo2 = plugRetangular2;
    return socket.fornecerEnergia(plugRedondo1, plugRedondo2);
  }
}