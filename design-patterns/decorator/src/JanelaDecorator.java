/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Magno
 */
public abstract class JanelaDecorator extends Janela{
    
    protected Janela janelaDecorada; 
    
    public JanelaDecorator(Janela janelaDecorada) {
        this.janelaDecorada = janelaDecorada; 
    } 
    public abstract void draw(); 
}

