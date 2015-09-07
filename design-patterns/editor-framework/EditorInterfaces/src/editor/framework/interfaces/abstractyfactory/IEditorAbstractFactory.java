

package editor.framework.interfaces.abstractyfactory;



public abstract class IEditorAbstractFactory {
    
    public static IEditorAbstractFactory getInstance()
    {
        return instance;
    }
    public abstract  IDocument CreateDocument();
    public abstract IDocumentVerifier CreateDocumentVerifier();
    public abstract IHelpEditor CreateHelpEditor();
    public abstract IEffectsEditor CreateEffectsEditor();
   
    // public IEditorAbstractFactory CreateEditorAbstractFactory();
     
    protected IEditorAbstractFactory() {}
    protected static IEditorAbstractFactory instance = null;
}
