package ru.itis.Task7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        if ((c < a + b && c > a - b)
                && (b < a + c && b > a - b)
                && (a < b + c && a > b - c)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
