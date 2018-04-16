import java.util.Arrays;

public class ArrayDisplayer {
    static String tabs = "";
    public static void show(int[] a, int lower, int higher, int num){
        int[] b = new int[higher - lower + 1];
        int k = 0;
        for (int i = lower; i < higher; i++){
            b[k] = a[i];
            k++;
        }
        //System.arraycopy(a, lower, b, lower, higher + 1 - lower);
        System.out.println(tabs + " " + num + " is here: " + Arrays.toString(b));
        tabs += "   ";
    }
}
