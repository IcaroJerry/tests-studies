/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.interfaces.exportBridge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ICAROJ
 */
public abstract class IExporters {
    
    public IExporters()
    {
        currentExporters = new ArrayList<>();
    } 
    
    public void addFormat(IFormat format)
    {
        currentExporters.add(format);
    }
    
    public List<String> getNamesFormat()
    {
        List<String> temp = new ArrayList<>();
        
        for(int i = 0; i< currentExporters.size(); i++)
        {
          temp.add(currentExporters.get(i).getName());
        }
    return temp;
    }
    
    public IFormat getFormat(String name)
    {
        for(int i = 0; i< currentExporters.size(); i++)
        {
            if(currentExporters.get(i).getName().equals(name)){
                return currentExporters.get(i);
            }
        }
        return null;
    }
    
    
    private static List<IFormat> currentExporters;
}
