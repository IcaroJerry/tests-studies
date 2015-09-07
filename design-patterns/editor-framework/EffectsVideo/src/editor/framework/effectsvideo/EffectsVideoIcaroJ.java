/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.effectsvideo;

import editor.framework.interfaces.decorators.IComponent;



/**
 *
 * @author ICAROJ
 */
public class EffectsVideoIcaroJ  extends IComponent{


   public EffectsVideoIcaroJ()
    {
        super();
        
        addDecorator(new Sepia());
        addDecorator(new BarrilDobrado());
        addDecorator(new Crepusculo());
        addDecorator(new Pisicodelico());
        addDecorator(new PorDoSol());
        addDecorator(new Magenta());

    }
    
}
