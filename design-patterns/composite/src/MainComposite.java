/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class MainComposite {
    
    public static void  main(String [] args){
        GraficoComposite a = new GraficoComposite("primeiro composite");
        GraficoComposite b = new GraficoComposite("segundo composite");
        GraficoComposite c = new GraficoComposite("terceiro composite");
        
        a.Add(new Folha("Primeira folha"));
        b.Add(new Folha("Segunda folha"));
        b.Add(new Folha("Terceira folha"));
        b.Add(new Folha("Quarta folha"));
        c.Add(new Folha("Quinta folha"));
        c.Add(a);
        c.Add(b);
        
        c.PrintAlgumaCoisa();
        
        
    }
    
    
}
