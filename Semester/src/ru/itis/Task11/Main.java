package ru.itis.Task11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] cor = scanner.next().toCharArray();
        int[] coor1 = {Integer.parseInt(String.valueOf(cor[0])), Integer.parseInt(String.valueOf(cor[1]))};

        cor = scanner.next().toCharArray();
        int[] coor2 = {Integer.parseInt(String.valueOf(cor[0])), Integer.parseInt(String.valueOf(cor[1]))};

        cor = scanner.next().toCharArray();
        int[] coor3 = {Integer.parseInt(String.valueOf(cor[0])), Integer.parseInt(String.valueOf(cor[1]))};

        double s = ((coor1[0] - coor3[0]) * (coor2[1] - coor3[3])) - ((coor2[0] - coor3[0]) * (coor1[1] - coor3[1]));
        System.out.println(s);


    }
}
