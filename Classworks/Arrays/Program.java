import java.util.Scanner;
class Program{
	public static void main(String[] args) {
		//int[] a = new int[5];
		int[] a = {1,2,-7,5,6};
		for (int i = 0;i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
		int[] b = new int[5];

		Scanner scanner = new Scanner(System.in);
		for (int i = 0;i < 5 ; i++) {
			int j = scanner.nextInt();
			a[i] = j;
		}

	}
}