package practice17;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(123);
        list.add(102);
        list.add(111);
        list.add(511);


        System.out.println("До сортировки");
        list.forEach(System.out::println);
        System.out.println();


        list.sort((num1, num2) -> {
            int sum1 = 0;
            int p1 = 1;

            //Считаю сумму и произведение в первом числе
            while (num1 > 0){
                int digit = num1 % 10;

                sum1 += digit;
                p1 *= digit;

                num1 /= 10;

            }

            int sum2 = 0;
            int p2 = 1;

            //Считаю сумму и произведение во втором числе
            while (num2 > 0){
                int digit = num2 % 10;

                sum2 += digit;
                p2 *= digit;

                num2 /= 10;
            }

            //Нахожу разницу
            int diff1 = Math.abs(sum1 - p1);
            int diff2 = Math.abs(sum2 - p2);


            return Integer.compare(diff2,diff1);
        });

        System.out.println("После сортировки");
        list.forEach(System.out::println);
    }
}
