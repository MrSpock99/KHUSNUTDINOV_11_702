package p8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        Map<Integer,Integer> digits = new HashMap<>();
        while (scanner.hasNext()){
            int number = scanner.nextInt();
            if (digits.get(number) != null){
                int count = digits.get(number);
                digits.put(number,++count);
            }else {
                digits.put(number,1);
            }
        }

        for (Integer key : digits.keySet()){
            System.out.println(key + " : " + digits.get(key) + " раз");
        }
    }
}
