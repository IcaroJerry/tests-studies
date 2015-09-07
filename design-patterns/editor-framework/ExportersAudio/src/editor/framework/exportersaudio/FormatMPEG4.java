/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.exportersaudio;

import editor.framework.exportersaudio.motorslibs.JAudioConverter;
import editor.framework.interfaces.exportBridge.IFormat;

/**
 *
 * @author ICAROJ
 */
public class FormatMPEG4 implements IFormat{

    public FormatMPEG4(){
        adapter = new JAudioConverter();
    }
    
    @Override
    public String getFormat() {
       return adapter.ToMPEG4(null);
    }

    @Override
    public String getName() {
           return "BITMAP";
    }
    
    private JAudioConverter adapter;
}
