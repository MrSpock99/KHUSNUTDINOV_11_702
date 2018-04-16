public class Main {
    public static void main(String[] args) {
        int a[] = {2, 4, 8, 11, 11, 13, 16, 19, 20};
        int num = find(a, 0, a.length - 1, 19);
        System.out.println(ArrayDisplayer.tabs + num + " is found");
    }

    public static int find(int a[], int lower, int higher, int num) {
        int mid = lower + (higher - lower) / 2;
        ArrayDisplayer.show(a, lower, higher, num);
        if (a[mid] > num) {
            return find(a, lower, mid, num);
        } else if (a[mid] < num) {
            return find(a, mid, higher, num);
        } else if (a[mid] == num) {
            return num;
        } else {
            return -1;
        }
    }
}
