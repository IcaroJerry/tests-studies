/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.effectsvideo;

import editor.framework.interfaces.IPlugin;



/**
 *
 * @author ICAROJ
 */
public class EffectsVideo  implements IPlugin{


  
    @Override
    public void initialize() {
          System.out.println("Lib: "+ EffectsVideo.class.getSimpleName() +" loaded!" );
    }

    
}
