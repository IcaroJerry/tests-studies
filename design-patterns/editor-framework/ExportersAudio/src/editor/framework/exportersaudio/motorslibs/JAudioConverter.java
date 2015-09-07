/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.exportersaudio.motorslibs;

import com.sun.imageio.plugins.jpeg.JPEGMetadata;
import java.awt.Image;


/**
 *
 * @author ICAROJ
 */
public class JAudioConverter {
    
    public String ToMPEG4(Image a)
    {
        return "mpeg4";
    }
    
    public String WAVE(Image a)
    {
        return "wave";
    }
    
     public String ToFlac(Image a)
    {
  
        return "falc";
    }
     public String ToMP3(Image a)
    {
        return "mp3";
    }
   
}
