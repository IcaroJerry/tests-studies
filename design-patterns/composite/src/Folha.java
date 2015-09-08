/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class Folha implements IGrafico{
     private String nome;
     
     public Folha(String nome){
         this.nome = nome;
     }

    public String getNome() {
        return nome;
    }

    	public void PrintAlgumaCoisa()
        {
           System.out.println("Imprime" + this.getNome());
        }

}
