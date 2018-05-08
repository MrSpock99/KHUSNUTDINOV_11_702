import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int CAPACITY = 1000000;
    private static final int BOUND = 1000;

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[CAPACITY];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(BOUND);
        }

        int cycleSum = 0;
        long timeBegin = System.currentTimeMillis();
        for (int anArr : arr) {
            cycleSum += anArr;
        }
        long timeEnd = System.currentTimeMillis();

        long cycleTime = timeEnd - timeBegin;

        int k = new Scanner(System.in).nextInt();
        int interval = CAPACITY / k;
        Thread[] threads = new Thread[k];

        int begin = 0;
        int end = interval;
        final int[] threadSum = {0};
        for (int i = 0; i < k; i++){
            int finalBegin = begin;
            int finalEnd = end;
            threads[i] = new Thread(() -> {
                for (int i1 = finalBegin; i1 < finalEnd; i1++){
                        threadSum[0] += arr[i1];
                        //System.out.println(threadSum[0]);
                }
            });
            if (i >= k - 2){
                end = arr.length;
            }else {
                end += interval;
            }
            begin += interval;
        }

        timeBegin = System.currentTimeMillis();
        for (int i = 0; i < k; i++){
            threads[i].start();
            threads[i].join();
        }
        timeEnd = System.currentTimeMillis();

        long threadTime = timeEnd - timeBegin;

        System.out.println();
        System.out.println("DONE!");
        System.out.println("threadSum = " + threadSum[0]);
        System.out.println("cycleSum  = " + cycleSum);
        System.out.println("Equals? " + (threadSum[0] == cycleSum));
        System.out.println();
        System.out.println("Cycle time = " + cycleTime);
        System.out.println("Thread time = " + threadTime);
        System.out.println("ThreadTIme - CycleTime = " + (threadTime - cycleTime));

    }

}
