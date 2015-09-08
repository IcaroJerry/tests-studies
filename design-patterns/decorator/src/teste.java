/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Magno
 */
public class teste {
    private Janela janelaDecorada;
    public static void main(String args[]) { 
       teste app = new teste();
       app.criando();
        
    }

public void criando()
{   
    this.janelaDecorada = new DecoradorBarraHorizontal (new DecoradorBarraVertical(new JanelaSimples())) {};
    janelaDecorada.draw();
}

   

    

   

   


    
}
