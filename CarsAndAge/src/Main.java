import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scannerUsers = new Scanner(new FileReader("users.txt"));
        Scanner scannerCars = new Scanner(new FileReader("cars.txt"));


        HashMap<Integer,Integer> map = new HashMap<>();

        while (scannerUsers.hasNextLine() && scannerCars.hasNextLine()){
            String user = scannerUsers.nextLine();
            String car = scannerCars.nextLine();

            String[] userArr = user.split(" ");
            String[] carArr = car.split(" ");

                int key = Integer.parseInt(userArr[2]);
                if (map.containsKey(key)) {
                    map.put(Integer.parseInt(userArr[2]), map.get(key) + 1);
                } else {
                    map.put(Integer.parseInt(userArr[2]), 1);

                }
        }

        for (Integer key : map.keySet()){
            System.out.println("Возраст: " +  key + " Кол-во машин " +  map.get(key));
        }

    }
}
