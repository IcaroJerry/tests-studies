
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRUNO
 */
public class GraficoComposite implements IGrafico{

    private List<IGrafico> graficos;
    private String nome;

    public String getNome() {
        return nome;
    }
    
    public GraficoComposite(String nome)
        {
            //initialize generic Collection(Composition)
            this.nome=nome;
            graficos = new ArrayList<IGrafico>();
            
            
              }
    
     public void Add(IGrafico grafico)
        {
            graficos.add(grafico);
        }
     
     public void remove(IGrafico grafico){
         graficos.remove(grafico);
     }
   
    
    /*
     * /
        //Adds multiple graphics to the composition
        public void AddRange(params IGraphic[] graphic)
        {
            graphics.AddRange(graphic);
        }
        
     */
    
     @Override
    public void PrintAlgumaCoisa() {
          System.out.println("ENTROU COMPOSITE IMPRIMINDO FORECAH");
         for(IGrafico a: graficos){
              System.out.println("Entrou em um Composite: " + this.getNome() + "imprime elementos: ");
             a.PrintAlgumaCoisa();
            
         }
        
    }
    
}
