/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassAdapter;

/**
 *
 * @author BRUNO
 */
public class TomadaRetangular {
  private String plugRetangular1;
  private String plugRetangular2;
  public void getPower() {
    AdaptadorDeTomadaRetangularParaTomadaRedonda adapter = new AdaptadorDeTomadaRetangularParaTomadaRedonda();
    String power = adapter.adapt(plugRetangular1, plugRetangular2);
    System.out.println(power);
  }
}

