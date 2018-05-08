import java.util.concurrent.atomic.AtomicInteger;

public class Synchronized {
    public static void main(String[] args) {
        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Поток "+ i);
            t.start();
        }
    }
    static class CommonResource{

        //int x;
        AtomicInteger x = new AtomicInteger(1);
        void increment(){
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), x.intValue());
                 x.getAndIncrement();
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        }
    }
    static class CountThread implements Runnable {

        CommonResource res;

        CountThread(CommonResource res) {
            this.res = res;
        }

        public void run() {
            res.increment();
        }
    }
}
