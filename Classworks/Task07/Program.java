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
		int j = 0;
		for (int i = a.length - 1;i > 0;i-- ) {
			for (int k = 0; k < a.length - j-1;k++ ) {
				if (a[k] < a[k+1]) {
					int val = a[k];
					a[k] = a[k+1];
					a[k+1] = val;
				}
			}
			j++;
		}

		for (int i = 0;i < a.length ;i++ ) {
			System.out.print(a[i] + " ");
		}
	}
}
