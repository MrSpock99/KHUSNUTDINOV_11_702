import java.util.Scanner;

class Program{
	public static void main(String[] args) {
		int[] a = new int[5];
		Scanner scanner = new Scanner(System.in);

		int min = 10;
		int pos = 0;

		for (int i = 0;i < 5 ;i++ ) {
			a[i] = scanner.nextInt();
		}
		for (int i = 0;i < a.length - 1;i++ ) {
			for (int k = i;k < a.length; k++) {
				if (a[k] < min) {
					min = a[k];
					pos = k;
				}
			}
			int val = a[i];
			a[pos] = val;
			a[i] = min;

			min = 10;
		}
		for (int i = 0;i < 5 ;i++ ) {
			System.out.print(a[i] + " ");
		}
	}
}