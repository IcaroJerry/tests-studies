/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package obsever;

/**
 *
 * @author ICAROJ
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Observed observadoUM =  new Observed();
        Observed observadoDOIS =  new Observed();
        
        Observer observadorUM = new Observer("observadorUM");
        Observer observadorDOIS = new Observer("observadorDOIS");
        Observer observadorTRES = new Observer("observadorTRES");
        Observer observadorQUATRO = new Observer("observadorQUATRO");
        
        observadoUM.addObserver(observadorUM);
        observadoUM.addObserver(observadorDOIS);
        observadoUM.addObserver(observadorTRES);
        
        observadoDOIS.addObserver(observadorQUATRO);
        
        observadoUM.setValor(10);
        observadoDOIS.setValor(110);
    }
    
}
