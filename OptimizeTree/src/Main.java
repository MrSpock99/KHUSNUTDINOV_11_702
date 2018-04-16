import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("in1"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for (int i = 1; i < n; i++){
            arr.add(scanner.nextInt());
        }

        RandomTree tree = new RandomTree(k);
        tree.setTree(arr);
        System.out.println(tree.optimize());

    }
}
