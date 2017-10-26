package ru.itis.Task19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();

        int count = 0;
        for (int i = 0; i < 4; i++){
            for (int k = 0; k < 4; k++){
                if (num1.charAt(i) == num2.charAt(k) && i != k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
