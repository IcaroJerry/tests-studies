/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.documentvideo.interfaces;

import editor.framework.documentvideo.products.elements.Frame;

/**
 *
 * @author ICAROJ
 */
public interface IteratorFrame {
    
    public  void first();
    public  void next();
    public  boolean isDone();
    public  Frame currentItem();
    
}
