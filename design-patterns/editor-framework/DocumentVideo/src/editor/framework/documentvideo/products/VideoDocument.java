

package editor.framework.documentvideo.products;


import editor.framework.documentvideo.products.elements.Frame;
import editor.framework.interfaces.abstractyfactory.IDocument;
import editor.framework.interfaces.exportBridge.IFormat;
import editor.framework.documentvideo.interfaces.IFrameController;
import editor.framework.menuoptionvideo.windowOption.algorithms.ModeFrameMedium;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public abstract class VideoDocument implements IDocument{
    
    public VideoDocument()
    {
        frames = new ArrayList<>();
        loadFrames();
        //default mode
        frameController = new ModeFrameMedium(this);
    }
    
    @Override
    public IFormat getFormat() {
        return this.format;
    }
    
    @Override
    public void setFormat(IFormat format) {
        this.format = format;
    }
           
    private void loadFrames()
    {
        int size = (new Random()).nextInt(100);
        for(int i =0; i< size ; i++)
        {
            this.frames.add(new Frame("frame:"+(i+1)));
        }
    }
    
    public final void executeVideo(){
      (new Thread(frameController)).start();
    }

    
    public IFrameController getFrameController() {
        return frameController;
    }

    public void setFrameController(IFrameController frameController) {
        this.frameController = frameController;
    }
    
    public List<Frame> getFrames() {
        return frames;
    }
    protected String nome = VideoDocument.class.getSimpleName();
    protected static IFormat format;
    protected List<Frame> frames;
    protected IFrameController frameController;
}
