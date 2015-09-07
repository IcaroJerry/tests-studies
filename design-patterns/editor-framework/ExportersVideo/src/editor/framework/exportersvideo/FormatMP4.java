/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.exportersvideo;

import editor.framework.exportersvideo.motorslibs.JVideoConverter;
import editor.framework.interfaces.exportBridge.IFormat;

/**
 *
 * @author ICAROJ
 */
public class FormatMP4 implements IFormat{
    
    public FormatMP4(){
        adapter = new JVideoConverter();
    }
    
    @Override
    public String getFormat() {
       return adapter.ToMP4(null);
    }

    @Override
    public String getName() {
         return "MP4";
    }
    
    private JVideoConverter adapter;
}
