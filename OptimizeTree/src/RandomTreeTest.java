import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomTreeTest {
    @Test
    public void test1() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("testInputs/in1"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        ArrayList arr = new ArrayList();
        arr.add(0);
        for (int i = 1; i < n; i++){
            arr.add(scanner.nextInt());
        }

        RandomTree tree = new RandomTree(k);
        tree.setTree(arr);

        int expected = 2;
        int actual = tree.optimize();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("testInputs/in2"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        ArrayList arr = new ArrayList();
        arr.add(0);
        for (int i = 1; i < n; i++){
            arr.add(scanner.nextInt());
        }

        RandomTree tree = new RandomTree(k);
        tree.setTree(arr);

        int expected = 7;
        int actual = tree.optimize();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test3() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("testInputs/in3"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        ArrayList arr = new ArrayList();
        arr.add(0);
        for (int i = 1; i < n; i++){
            arr.add(scanner.nextInt());
        }

        RandomTree tree = new RandomTree(k);
        tree.setTree(arr);

        int expected = 2;
        int actual = tree.optimize();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test4() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("testInputs/in4"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        ArrayList arr = new ArrayList();
        arr.add(0);
        for (int i = 1; i < n; i++){
            arr.add(scanner.nextInt());
        }

        RandomTree tree = new RandomTree(k);
        tree.setTree(arr);

        int expected = 0;
        int actual = tree.optimize();

        Assert.assertEquals(expected,actual);
    }

}