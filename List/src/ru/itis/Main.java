package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList list = null;

        while (true){
            System.out.println("Введите номер комманды");
            String[] commands = {"1. Создать массив", "2. Добавить число в конец массива","3. Удалить число из массива","4. Вставить число в массив","5. Вывести массив на экран", "6. Выход"};
            System.out.println("");


            for(String command : commands){
                System.out.println(command);
            }

            System.out.print("command = ");


            Scanner scanner = new Scanner(System.in);
            int commandNum = scanner.nextInt();
        switch(commandNum){
            case 1:
                System.out.println("Введите размер массива");
                System.out.print("length = ");
                int length = scanner.nextInt();

                list = new ArrayList(length);
                break;
            case 2:
                System.out.println("Введите число");
                System.out.print("n = ");
                int n = scanner.nextInt();

                list.addNum(n);
                break;
            case 3:
                System.out.println("Введите индекс");
                System.out.print("index = ");
                int index = scanner.nextInt();

                list.removeNum(index);
                break;
            case 4:
                System.out.println("Введите число");
                System.out.print("num = ");
                int num = scanner.nextInt();
                System.out.println("");

                System.out.println("Введите индекс");
                System.out.print("index = ");
                int index1 = scanner.nextInt();

                list.addNum(num, index1);
                break;
            case 5:
                System.out.println("");

                list.showList();
                break;

            case 6:
                System.exit(0);
        }


        System.out.println("");
        System.out.println("------------------------------------------------------------------");
    }
    }
}
