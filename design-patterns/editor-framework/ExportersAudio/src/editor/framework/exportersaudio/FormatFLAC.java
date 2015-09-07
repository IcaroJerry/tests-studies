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
public class FormatFLAC implements IFormat{

     public FormatFLAC(){
        adapter = new JAudioConverter();
    }
     
    @Override
    public String getFormat() {
       return adapter.ToFlac(null);
    }

    @Override
    public String getName() {
       return "FLAC";
    }
    private JAudioConverter adapter;
}
