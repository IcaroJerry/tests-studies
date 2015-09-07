/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.exportersaudio;

import editor.framework.interfaces.exportBridge.IExporters;

/**
 *
 * @author ICAROJ
 */
public class ExporterAudio extends IExporters{

    public ExporterAudio()
    {
        super();
        
        addFormat(new FormatFLAC());
        addFormat(new FormatMP3());
        addFormat(new FormatWave());
        addFormat(new FormatIcaroJ());
        addFormat(new FormatMPEG4());

    }
 
}
