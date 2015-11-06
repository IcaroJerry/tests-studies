package producerconsumer;

public class OneThread extends Thread { 

        public OneThread(String id, MultiThread x, int delay) {

               super(id);
               a = x;
               
               this.delay = delay;

        }

        public void run() {

               String id = this.getName();

               try {
                   sleep(delay);
		   a.setShared(a.getShared() + 2);
               }

               catch(InterruptedException e) {
                   System.out.println("Thread:  "+ id + " foi interrompida"); 
               }

               System.out.println(">>" + id + " " + delay);
               System.out.println("Variavel = " + a.getShared() + " ");
        }
    private int delay;
    private MultiThread a;
}
