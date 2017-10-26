package ru.itis.Task10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        if (a == 0 && b == 0 && c == 0) {
            System.out.println(-1);
        } else {

            double d = Math.pow(b, 2) - 4 * a * c;

            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println(x1 + "\n" + x2);
            } else if (d < 0) {
                System.out.println("There is no solutions");
            } else {
                double x1 = (-b + Math.sqrt(d)) / 2 * a;
                System.out.println(x1);
            }
        }
    }

}
