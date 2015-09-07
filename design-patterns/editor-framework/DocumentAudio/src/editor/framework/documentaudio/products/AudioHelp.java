

package editor.framework.documentaudio.products;

import editor.framework.interfaces.abstractyfactory.IHelpEditor;


public class AudioHelp implements IHelpEditor{

    @Override
    public String showMessage() {
        return "Implementação completa de "+this.getClass().getSimpleName()+" em construção!";
    }
    
}
