import java.util.Scanner;
class Program{
	public static void main(String[] args) {
		int[] a = new int[6];
		Scanner scanner = new Scanner(System.in);

		for (int i = 0;i < a.length ;i++ ) {
			a[i] = scanner.nextInt();
		}

		for (int i = 0; i < a.length/2 ; i++ ) {
			int val = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = val;

		}
		for (int i = 0;i < a.length ;i++ ) {
			System.out.print(a[i] + " ");
		}
	}
}