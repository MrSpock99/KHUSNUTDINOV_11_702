package p9;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        list.sort((o1, o2) -> {
            int fiveCount1 = 0;
            while (o1 > 0){
                int digit = o1 % 10;
                if (digit == 5){
                    fiveCount1++;
                }
                o1 /= 10;
            }

            int fiveCount2 = 0;
            while (o2 > 0){
                int digit = o2 % 10;
                if (digit == 5){
                    fiveCount2++;
                }
                o2 /= 10;
            }

            return Integer.compare(fiveCount1,fiveCount2);
        });

        Writer writer = new FileWriter("out.txt",true);

        for (int i : list){
            writer.write(String.valueOf(i) + "\n");
        }
        writer.close();

    }
}
