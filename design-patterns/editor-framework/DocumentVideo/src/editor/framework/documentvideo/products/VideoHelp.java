

package editor.framework.documentvideo.products;

import editor.framework.interfaces.abstractyfactory.IHelpEditor;


public class VideoHelp implements IHelpEditor{

    @Override
    public String showMessage() {
        return "Implementação completa de "+this.getClass().getSimpleName()+" em construção!";
    }
    
}
