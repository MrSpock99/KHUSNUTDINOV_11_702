package ru.itis.Task13;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        char[] input = new Scanner(System.in).next().toCharArray();
        char[] reversed = getReversed(input);

        if (Arrays.equals(input, reversed)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static char[] getReversed(char[] c){
        char[] res = new char[c.length];
        int k = 0;
        for (int i = c.length - 1; i >= 0; i--){
            res[k] = c[i];
            k++;
        }
        return res;
    }
}
