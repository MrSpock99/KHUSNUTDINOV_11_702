package ru.itis.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();

        int[] coor1 = {input1.charAt(0) - 'a'+1,input1.charAt(1) - '0'};
        int[] coor2 = {input2.charAt(0) - 'a'+1,input2.charAt(1) - '0'};

        if ((coor1[1] + 1 == coor2[1] || coor1[1] + 2 == coor2[1]) && (coor1[0] == coor2[0])){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }



    }

}
