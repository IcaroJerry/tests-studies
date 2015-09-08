/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Magno
 */
public class DecoradorBarraVertical extends JanelaDecorator{
    
  public DecoradorBarraVertical(Janela janelaDecorada) {
      super(janelaDecorada);       
  }
  
  public void draw() {
		drawBarraVertical();
		janelaDecorada.draw();
	}
  
  public void drawBarraVertical() {
      System.out.println("desenha uma barra vertical na janela");
  }


}