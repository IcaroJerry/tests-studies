/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.documentvideo.interfaces;

import editor.framework.documentvideo.products.VideoDocument;
import editor.framework.documentvideo.products.elements.Frame;
import java.util.List;

/**
 *
 * @author ICAROJ
 */
public abstract class IFrameController implements IContainerFrame, Runnable{
   
    public IFrameController(VideoDocument document)
    {
        this.famesVideo = document.getFrames();
        if(this.famesVideo == null)
          throw new NullPointerException("frames of video is null!");
    }
    
    protected abstract void executeFrames();   
        private  void execute()
    {  
        System.out.println("Começando a executar video:");
        System.out.print("---------------------------------\n");
        this.getInterator().first();
            executeFrames();
        System.out.println("\n--------------------------------");
        System.out.println("Video terminou de ser executado.");
    }
    
    @Override
    public void run(){
        this.execute();
    }
    
    
    protected final List<Frame>  famesVideo;
}
