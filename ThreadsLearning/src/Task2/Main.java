package Task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++){
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        for (int i = 0; i < 5; i++){
            System.out.println("BLA BLA BLA");
        }

    }
}
