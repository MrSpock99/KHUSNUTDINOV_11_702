package ru.itis.Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] coor1 = scanner.next().toCharArray();
        char[] coor2 = scanner.next().toCharArray();



        if (((coor1[0] + 1 == coor2[0] || coor1[0] - 1 == coor2[0]) && coor1[1] + 2 == coor2[1])
                || (((coor1[1] + 1 == coor2[1]) || coor1[1] - 1 == coor2[1]) && coor1[0] + 2 == coor2[0])
                || (((coor1[0] + 1 == coor2[0]) || coor1[0] - 1 == coor2[0]) && coor1[1] - 2 == coor2[1])
                || (((coor1[1] + 1 == coor2[1]) || coor1[1] - 1 == coor2[1]) && coor1[0] - 2 == coor2[0])) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }


    }

    private static boolean contains(char el, char[] mas) {
        for (char ch : mas) {
            if (ch == el) {
                return true;
            }
        }
        return false;

    }
}
