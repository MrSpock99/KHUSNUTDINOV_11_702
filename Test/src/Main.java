import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int shift = new Scanner(System.in).nextInt();
        for (int k = 0; k < Math.abs(shift); k++) {
            if (shift < 0) {
                for (int i = 0; i < a.length - 1; i++) {
                    a[i] = a[i + 1];
                }
                a[a.length - 1] = 0;
            }
            if (shift > 0){
                for (int i = a.length - 1; i > 0; i--) {
                    a[i] = a[i - 1];
                }
                a[0] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
