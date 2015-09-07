/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menuoptionvideo.windowOption.algorithms;

import editor.framework.documentvideo.products.VideoDocument;
import editor.framework.documentvideo.products.elements.Frame;
import editor.framework.documentvideo.interfaces.IFrameController;
import editor.framework.documentvideo.interfaces.IteratorFrame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ICAROJ
 */
public class ModeFrameMedium extends IFrameController implements IteratorFrame{

    public ModeFrameMedium(VideoDocument famesVideo) {
        super(famesVideo);
    }

    @Override
    protected void executeFrames() {
        System.out.println("#running on medium quality frames:");
        auxFormat = 0;
        
        while(!this.isDone())
        {    
          System.out.print(this.getInterator().currentItem().showFrame()+"- ");
          if(auxFormat == 5)
          {
            System.out.println("");
            auxFormat = 0;
          }
          
          this.next();
          auxFormat++;
           try {
            Thread.sleep(200);
            } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            }
        }
    }

    @Override
    public void first() {
        currentPosition = 0;
    }

    @Override
    public void next() {
            currentPosition++;
            currentPosition++;
    }

     @Override
    public boolean isDone() {
        return this.famesVideo.size() <= currentPosition;
    }

    @Override
    public Frame currentItem() {
        return famesVideo.get(currentPosition);
    }
    
      @Override
    public IteratorFrame getInterator(){
        return this;
    }
    
      private int auxFormat;
      private int currentPosition;
}
