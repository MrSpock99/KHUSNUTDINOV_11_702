package ru.itis.Task8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inp = scanner.next().toCharArray();
        int x1 = inp[0];
        int y1 = inp[1];
        int r1 = scanner.nextInt();

        inp = scanner.next().toCharArray();
        int x2 = inp[0];
        int y2 = inp[1];
        int r2 = scanner.nextInt();

        double s = Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));

        if (s < (r1 +r2) && (s > (r1 - r2))){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }






    }
}
