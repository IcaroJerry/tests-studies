/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.exportersaudio;

import editor.framework.interfaces.exportBridge.IFormat;

/**
 *
 * @author ICAROJ
 */
public class FormatIcaroJ implements IFormat{

    @Override
    public String getFormat() {
       return "ij";
    }

    @Override
    public String getName() {
           return "IcaroJ";
    }
    
}
