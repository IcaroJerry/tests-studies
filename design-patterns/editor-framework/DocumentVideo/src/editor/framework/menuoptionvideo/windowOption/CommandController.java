/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menuoptionvideo.windowOption;

import editor.framework.documentvideo.interfaces.ICommand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ICAROJ
 */
public class CommandController {
    
    public CommandController(List<ICommand> comands){
    
        this.commands =  comands;
        this.executedCommand = new ArrayList();
    }
   
    public void changeFrameControllerLow(){
      this.executedCommand.add(this.commands.get(0));
      this.commands.get(0).execute();
    }
    
    public void changeFrameControllerMedium(){
      this.executedCommand.add(this.commands.get(1));
      this.commands.get(1).execute();
    }
    
    public void changeFrameControllerHigh(){
      this.executedCommand.add(this.commands.get(2));
      this.commands.get(2).execute();
    }
    
    public void undo(){
        this.executedCommand.get(this.executedCommand.size()-1).undo();
        this.executedCommand.remove(this.executedCommand.size()-1);
    }
    
    List<ICommand>  executedCommand;
    List<ICommand> commands;
}
