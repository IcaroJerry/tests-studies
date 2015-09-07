/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.exportersvideo;

import editor.framework.interfaces.exportBridge.IExporters;

/**
 *
 * @author ICAROJ
 */
public class ExporterVideo extends IExporters{

    public ExporterVideo()
    {
        super();
        
        addFormat(new FormatVOB());
        addFormat(new FormatMP4());
        addFormat(new FormatWMV());
        addFormat(new FormatIcaroJ());
        addFormat(new FormatAVI());

    }
 
}
