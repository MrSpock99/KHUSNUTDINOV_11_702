package ru.itis.Task20;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] num1 = scanner.next().split("");
        String[] num2 = scanner.next().split("");

        if ((Integer.parseInt(num1[0]) + Integer.parseInt(num2[0]) + Integer.parseInt(num1[1]) + Integer.parseInt(num2[1]) + Integer.parseInt(num1[2]) + Integer.parseInt(num2[2])) % 10
                == (Integer.parseInt(num1[3]) + Integer.parseInt(num2[3]) + Integer.parseInt(num1[4]) + Integer.parseInt(num2[4]) + Integer.parseInt(num1[5]) + Integer.parseInt(num2[5])) % 10){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
