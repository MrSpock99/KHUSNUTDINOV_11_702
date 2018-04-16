import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Map<Integer,ArrayList<Double>> months = new HashMap<>();
        Scanner scanner = new Scanner(file);
        String s = "";
        ArrayList<Double> list;
        while (scanner.hasNextLine()){
            s = scanner.nextLine();
            String monthStr = s.substring(3,5);
            String valueStr = s.substring(5,s.length());

            int monthInt = Integer.parseInt(monthStr);
            double valueDouble = Double.parseDouble(valueStr);

            if (!months.containsKey(monthInt)){
                list = new ArrayList();
                list.add(valueDouble);
                months.put(monthInt,list);
            }else {
                list = months.get(monthInt);
                list.add(valueDouble);
                months.put(monthInt,list);
            }

        }

        Map<Integer, Double> monthsMed = new HashMap<>();

        for (Integer key : months.keySet()){
            list = months.get(key);
            monthsMed.put(key,sum(list));
        }

        double yearMed = 0;
        for (Integer key : monthsMed.keySet()){
             yearMed += monthsMed.get(key);
        }

        yearMed /= 366;

        for (Integer key : months.keySet()){
            list = months.get(key);
            monthsMed.put(key,sum(list)/list.size());
        }

        double min = Double.MAX_VALUE;
        int minMonth = 0;
        for (Integer key : monthsMed.keySet()){
            if (Math.abs(yearMed - monthsMed.get(key)) < min){
                min = Math.abs(yearMed - monthsMed.get(key));
                minMonth = key;
            }
        }

        System.out.println(minMonth);

        for (Integer key : monthsMed.keySet()){
            if (Math.abs(yearMed - monthsMed.get(key)) == min){
                System.out.println(key);
            }
        }


    }

    static double sum(ArrayList<Double> list){
        double s = 0;
        for (double d : list){
            s += d;
        }
        return s;
    }
}
