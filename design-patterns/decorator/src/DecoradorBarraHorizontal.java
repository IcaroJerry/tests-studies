/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class DecoradorBarraHorizontal extends JanelaDecorator{
 
  public DecoradorBarraHorizontal(Janela janelaDecorada) {
      super(janelaDecorada);       
  }
  
  @Override
  public void draw() {
		drawBarraHorizontal();
		janelaDecorada.draw();
	}
  
  public void drawBarraHorizontal() {
      System.out.println("desenha uma barra HORIZONTAL na janela");
  }
}
