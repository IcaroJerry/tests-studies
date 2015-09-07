package editor.framework.exportersaudio;


import editor.framework.interfaces.IPlugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ICAROJ
 */
public class ExportersAudio implements IPlugin{

    @Override
    public void initialize() {
        System.out.println("Lib: "+ ExporterAudio.class.getSimpleName() +" loaded!" );
    }
    
}
