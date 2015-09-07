/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menuoptionvideo.interfaces;

/**
 *
 * @author ICAROJ
 */
public abstract class IFrameController {
   
    public IFrameController(Object documentVideo)
    {
        this.documentVideo = documentVideo;
    }
    
    public abstract void executeNext();
    protected final Object documentVideo;
}
