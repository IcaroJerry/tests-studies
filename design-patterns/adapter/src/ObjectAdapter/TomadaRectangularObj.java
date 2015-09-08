/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectAdapter;

/**
 *
 * @author BRUNO
 */
public class TomadaRectangularObj {
  private String plugRetangular1;
  private String plugRetangular2;
  
  public void getPower() {
    AdaptadorDeTomadaRetangularParaTomadaRedondaObj adapter = new AdaptadorDeTomadaRetangularParaTomadaRedondaObj();
    String power = adapter.adapt(plugRetangular1, plugRetangular2);
    System.out.println(power);
    
  }
}
