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
public class FormatMP3 implements IFormat{
    
    public FormatMP3(){
        adapter = new JAudioConverter();
    }
    
    @Override
    public String getFormat() {
       return adapter.ToMP3(null);
    }

    @Override
    public String getName() {
         return "MP3";
    }
    
    private JAudioConverter adapter;
}
