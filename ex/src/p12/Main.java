package p12;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(51);
        list.add(70);
        list.add(25);
        list.add(19);

        list.sort((o1, o2) -> {
            int mirror1 = 0;
            int a = o1;
            int count = 0;
            while (a > 0){
                a /= 10;
                count++;
            }
            while (o1 > 0){
                int digit = o1 % 10;
                mirror1 += digit * Math.pow(10,count);
                count--;
                o1 /= 10;
            }

            count = 0;
            int mirror2 = 0;
            int b = o2;
            while (b > 0){
                b /= 10;
                count++;
            }
            while (o2 > 0){
                int digit = o2 % 10;
                mirror2 += digit * Math.pow(10,count);
                count--;
                o2 /= 10;
            }

            return Integer.compare(mirror1,mirror2);
        });

        list.forEach(System.out::println);
    }
}
