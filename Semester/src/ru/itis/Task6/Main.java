package ru.itis.Task6;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        Date date1 = new Date(year);
        date1.addDays(256);
        System.out.println(date1);
    }
}
