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
public class FormatVOB implements IFormat{

     public FormatVOB(){
        adapter = new JVideoConverter();
    }
     
    @Override
    public String getFormat() {
       return adapter.ToVOB(null);
    }

    @Override
    public String getName() {
       return "VOB";
    }
    private JVideoConverter adapter;
}
