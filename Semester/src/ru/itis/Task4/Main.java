package ru.itis.Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] coor1 = scanner.next().toCharArray();
        char[] coor2 = scanner.next().toCharArray();

        if (coor1[0] == coor2[0] || coor1[1] == coor2[1]){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
