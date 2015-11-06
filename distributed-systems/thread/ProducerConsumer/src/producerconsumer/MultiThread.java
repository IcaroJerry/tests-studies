package producerconsumer;

public class MultiThread  {

        MultiThread () {
            shared = 1;
        }

        public static void main(String[] args) {
               MultiThread t = new MultiThread();
               t.run();
        }

        public void run() {
               OneThread t1,t2,t3;
               
               t1 = new OneThread("First", this, (int)(Math.random()*8000));

               t2 = new OneThread("Second", this, (int)(Math.random()*8000));

               t3 = new OneThread("Third", this, (int)(Math.random()*8000));
               
               t1.start();

               t2.start();

               t3.start();
        }

        public void setShared(int s){
            this.shared = s;
        }

        public int getShared(){
            return this.shared;
        }

	private int shared;
}
