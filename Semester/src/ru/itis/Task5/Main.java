package ru.itis.Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp1 = scanner.next();
        String inp2 = scanner.next();

        int[] cor1 = {inp1.charAt(0) - 'a' + 1, inp1.charAt(1) - '0'};
        int[] cor2 = {inp2.charAt(0) - 'a' + 1, inp2.charAt(1) - '0'};

        String res = "";
        if (Math.abs(cor1[0] - cor1[1]) == Math.abs(cor2[0] - cor2[1])){
            res = "SAME";
        }else{
            int sum00 = cor1[0] + cor2[1];
            int sum11 = cor1[1] + cor2[1];

            if (Math.abs(sum00 - sum11) == 1 || Math.abs(sum00 - sum11) == 2){
                res = "NEIGHBOR";
            }
        }

        System.out.println(res);
    }


}






















