package Task2;

public class Processor implements Runnable {
    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException ignored){}

        System.out.println("Completed: " + id);
    }


}

