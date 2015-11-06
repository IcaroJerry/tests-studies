package producerconsumer;

public class Producer extends Thread {

        public Producer(Main x, String id) {
            this.a = x;
            this.counter =0;
            this.id = id;
        }

        public void run() {
               try {
                   while (true) {
                       while (a.getBuffer().size()== 10)
                           sleep(100);
                       a.ss1.acquire();
                       toProduce();
                       a.ss2.release();
                   }
               }
               catch(InterruptedException e) {
                       e.printStackTrace(); 
               }
        }
        
        public void toProduce(){
            counter ++;
            a.getBuffer().add(counter);
            a.increaseItemCount();
            System.out.println("produtor"+id+": producing item "+counter);
        }

	private int counter;
        private Main a;
        private String id;
}
