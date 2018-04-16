import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MatrixImpl matrix = new MatrixImpl();
        matrix.set(1,1, 1);
        matrix.set(1,2, 2);
        matrix.set(2,1, 3);
        matrix.set(0,0, 4);


        Map<Integer[], Integer> el = matrix.getMapElements();


        System.out.println(matrix.get(1,1));
    }
}
