import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;


public class SparseMatrixTest {

    @Test
    public void transpose(){
        Integer[][] arr1 = {{0,2,3},{4,0,0},{0,0,5}};

        SparseMatrix<Integer> actual = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr1)));
        actual.transpose();

        SparseMatrix<Integer> expected = new SparseMatrix<>(new SimpleMatrix(getIntegerList(new Integer[][]{{0,4,0},{2,0,0},{3,0,5}})));
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void multiplyInt1(){
        Integer[][] arr1 = {{0,2,3},{4,0,0},{0,0,5}};
        Integer[][] arr2 = {{0,0,7},{0,8,0},{0,9,6}};

        SparseMatrix<Integer> m1 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr1)));
        SparseMatrix<Integer> m2 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr2)));

        SparseMatrix<Integer> actual = (SparseMatrix<Integer>) m1.multiply(m2);
        SparseMatrix<Integer> expected = new SparseMatrix<>(new SimpleMatrix(getIntegerList(new Integer[][]{{0,43,18},{0,0,28},{0,45,30}})));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void multiplyInt2(){
        Integer[][] arr1 = {{1,0,0,2},{0,0,2,1},{3,5,0,0}};
        Integer[][] arr2 = {{5,0,0,1},{0,1,0,0},{1,0,0,0},{0,1,0,0}};

        SparseMatrix<Integer> m1 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr1)));
        SparseMatrix<Integer> m2 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr2)));

        SparseMatrix<Integer> actual = (SparseMatrix<Integer>) m1.multiply(m2);
        SparseMatrix<Integer> expected = new SparseMatrix<>(new SimpleMatrix(getIntegerList(new Integer[][]{{5,2,0,1},{2,1,0,0},{15,5,0,3}})));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void multiplyInt3(){
        Integer[][] arr1 = {{1,0,0,2},{0,0,2,1},{3,5,0,0}};
        Integer[][] arr2 = {{5,0,0,1},{0,1,0,0},{1,0,0,0},{0,1,0,0}};

        SparseMatrix<Integer> m1 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr1)));
        SparseMatrix<Integer> m2 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr2)));

        SparseMatrix<Integer> actual = (SparseMatrix<Integer>) m1.multiply(m2);
        SparseMatrix<Integer> expected = new SparseMatrix<>(new SimpleMatrix(getIntegerList(new Integer[][]{{5,2,0,0},{2,1,0,0},{15,5,0,3}})));

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void multiplyDouble(){
        Double[][] arr1 = {{0.5,0.0,0.0,2.0},{0.0,0.0,3.5,1.0},{3.0,5.0,0.0,0.0}};
        Double[][] arr2 = {{0.5,0.0,0.0,1.0},{0.0,1.0,0.0,0.0},{1.0,0.0,0.0,0.0},{0.0,0.5,0.0,0.0}};

        SparseMatrix<Double> m1 = new SparseMatrix<>(new SimpleMatrix<Double>(getDoubleList(arr1)));
        SparseMatrix<Double> m2 = new SparseMatrix<>(new SimpleMatrix<Double>(getDoubleList(arr2)));

        SparseMatrix<Double> actual = (SparseMatrix<Double>) m1.multiply(m2);
        SparseMatrix<Double> expected = new SparseMatrix<>(new SimpleMatrix(getDoubleList(new Double[][]{{0.25,1.0,0.0,0.25},{3.5,1.0,0.0,0.0},{1.5,5.0,0.0,3.0}})));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subtractInt1(){
        Integer[][] arr1 = {{1,0,0,2},{0,0,2,1},{3,5,0,0},{0,1,0,0}};
        Integer[][] arr2 = {{5,0,0,1},{0,1,0,0},{1,0,0,0},{0,1,0,0}};

        SparseMatrix<Integer> m1 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr1)));
        SparseMatrix<Integer> m2 = new SparseMatrix<>(new SimpleMatrix<Integer>(getIntegerList(arr2)));

        SparseMatrix<Integer> actual = (SparseMatrix<Integer>) m1.subtract(m2);
        SparseMatrix<Integer> expected = new SparseMatrix<>(new SimpleMatrix(getIntegerList(new Integer[][]{{-4,0,0,1},{0,-1,2,1},{2,5,0,0},{0,0,0,0}})));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subtractDouble1(){
        Double[][] arr1 = {{0.5,1.5},{0.0,0.0}};
        Double[][] arr2 = {{0.0,1.5},{0.5,0.0}};

        SparseMatrix<Double> m1 = new SparseMatrix<>(new SimpleMatrix<Double>(getDoubleList(arr1)));
        SparseMatrix<Double> m2 = new SparseMatrix<>(new SimpleMatrix<Double>(getDoubleList(arr2)));

        SparseMatrix<Double> actual = (SparseMatrix<Double>) m1.subtract(m2);
        SparseMatrix<Double> expected = new SparseMatrix<>(new SimpleMatrix(getDoubleList(new Double[][]{{0.5,0.0},{-0.5,0.0}})));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void serialize(){
        SparseMatrix<Integer> expected = null;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("matrix.txt"));

            Integer[][] arr1 = {{0,2,3},{4,0,0},{0,0,5}};
            expected = new SparseMatrix<>(new SimpleMatrix<>(getIntegerList(arr1)));

            oos.writeObject(expected);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Before serialization");
        System.out.println(expected.toString());

        SparseMatrix<Integer> actual = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("matrix.txt"));
            actual = (SparseMatrix<Integer>)ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("After serialization");
        System.out.println(actual.toString());

        Assert.assertEquals(expected,actual);
    }

    private ArrayList<ArrayList<Double>> getDoubleList(Double[][] arr) {
        ArrayList<ArrayList<Double>> list = new ArrayList<>();
        ArrayList<Double> inner = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                inner.add(arr[i][j]);
            }
            list.add(inner);
            inner = new ArrayList<>();
        }
        return list;    }


    private ArrayList<ArrayList<Integer>> getIntegerList(Integer[][] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                inner.add(arr[i][j]);
            }
            list.add(inner);
            inner = new ArrayList<>();
        }
        return list;
    }

}