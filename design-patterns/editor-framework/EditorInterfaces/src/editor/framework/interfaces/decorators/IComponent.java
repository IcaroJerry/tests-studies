/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.interfaces.decorators;

import editor.framework.interfaces.abstractyfactory.IDocument;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ICAROJ
 */
public abstract class IComponent {
    public IComponent()
    {
        currentDecorators = new ArrayList<>();
    } 
    
    public void addDecorator(IDocumentDecorator decorator)
    {
        currentDecorators.add(decorator);
    }
    
    public List<String> getNamesDecorators()
    {
        List<String> temp = new ArrayList<>();
        
        for(int i = 0; i< currentDecorators.size(); i++)
        {
          temp.add(currentDecorators.get(i).getName());
        }
    return temp;
    }
    
    public void applyEffects(String name, IDocument doc)
    {
        for(int i = 0; i< currentDecorators.size(); i++)
        {
            if(currentDecorators.get(i).getName().equals(name)){
                {currentDecorators.get(i).setDocument(doc);
                    return;}
            }
        }
    }
    
    
    private static List<IDocumentDecorator> currentDecorators; 
}
