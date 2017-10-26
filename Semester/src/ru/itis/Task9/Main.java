package ru.itis.Task9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayList<String> res = new ArrayList<>();

        int k = 2;
        for (String anInput : input) {
            if (!anInput.equals("0")) {
                if (k != 1 && k != 0) {
                    if (!anInput.equals("1")) {
                        res.add(anInput + "x" + "^" + k);
                    }else {
                        res.add("x" + "^" + k);
                    }
                } else if (k == 1) {
                    if (!anInput.equals("1") && !anInput.equals("-1")) {
                        res.add(anInput + "x");
                    }else {
                        res.add("x");
                    }
                } else {
                    res.add(anInput);
                }
            }
            k--;
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1 && !res.get(i+1).contains("-")){
                System.out.print("+");
            }
        }
    }
}



