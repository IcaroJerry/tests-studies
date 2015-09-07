/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.interfaces;

/**
 *
 * @author ICAROJ
 */
public interface IObservable {
   
    public void registerObserver(IObserver obj);
    public void removeObserver(IObserver obj);
    public void notifyAllObserver();
    //public void notifyObeserver(IObserver obj);
    
}
