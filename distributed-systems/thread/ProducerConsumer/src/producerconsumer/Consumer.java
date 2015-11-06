package producerconsumer;

public class Consumer extends Thread {
    
    public Consumer(Main x, String id) {
        a = x;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                while (a.getBuffer().size()== 0)
                    sleep(100);
                a.ss2.acquire();
                toConsume();
                a.ss1.release();
            }
        }
        catch(InterruptedException e) {
                e.printStackTrace(); 
        }
    }
    public void toConsume(){
        int item;
        item = (Integer) a.getBuffer().get(0);
        a.getBuffer().remove(0);
        a.increaseItemCount();
        System.out.println("consumer"+id+": consuming item "+item);
    }
    private Main a;
    private String id;
}
