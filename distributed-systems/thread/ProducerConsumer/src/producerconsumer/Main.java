package producerconsumer;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main  {

    Main () {
        itemCount = 0;
        buffer = new ArrayList(); 
        ss1 = new Semaphore(1);
        ss2 = new Semaphore(0);
    }
    
    public static void main(String[] args) {
        Main t = new Main();
        t.run();
    } 
        
    public void run() {
        Consumer c = new Consumer(this, "_2");
        Producer p = new Producer(this, "_1");
        
        c.start();
        p.start();
        
        Consumer c1 = new Consumer(this, "_2");
        Producer p1 = new Producer(this,"_1");

        c1.start();
        p1.start();
    }
    
    public int getShared(){
        return this.shared;
    }
    
    public void setShared(int s){
        this.shared = s;
    }
    public int getItemCount(){
        return this.itemCount;
    }
    public void increaseItemCount(){
        this.itemCount++;
    }
    public void desincreaseItemCount(){
        this.itemCount--;
    }
    public ArrayList getBuffer(){
        return this.buffer;
    }
    
    private int shared;
    private int itemCount;
    private ArrayList buffer;
    public static Semaphore ss1;
    public static Semaphore ss2;
}
