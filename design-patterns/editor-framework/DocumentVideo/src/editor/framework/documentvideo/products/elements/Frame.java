/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.documentvideo.products.elements;

/**
 *
 * @author ICAROJ
 */
public class Frame {
  
    public Frame(String frame)
    {
        setFrame(frame);
    }
    
    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }  
    
    public String showFrame(){
    
      return "-"+frame ;
    }
    
    private String frame;
}
