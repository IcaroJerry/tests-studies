/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.effectsaudio;

import editor.framework.interfaces.decorators.IComponent;



/**
 *
 * @author ICAROJ
 */
public class EffectsAudioIcaroJ  extends IComponent{


   public EffectsAudioIcaroJ()
    {
        super();
        
        addDecorator(new Aplausos());
        addDecorator(new Laser());
        addDecorator(new Tiroteio());
        addDecorator(new SomPisicodelico());
        addDecorator(new Tambor());
        addDecorator(new Suspense());

    }
    
}
