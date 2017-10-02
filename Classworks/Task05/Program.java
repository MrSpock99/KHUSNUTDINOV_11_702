import java.util.Scanner;
class Program{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int j = scanner.nextInt();
		int[] a = new int[5];
		for (int i = 0;i < 5 ;i++ ) {
			a[i] = scanner.nextInt();
		}
		int max = -11;
		int maxPos = 0;
		int min = 11;
		int minPos = 0;

		for (int i = 0;i < 5 ;i++ ) {
			System.out.print(a[i] + " ");
		}

		
		System.out.println();


		for (int i = 0;i < 5 ;i++ ) {
			if (a[i] > max){
				max = a[i];
				maxPos = i;
			}
			if (a[i] < min) {
				min = a[i];
				minPos = i;
			}
		}
		a[maxPos] = min;
		a[minPos] = max;

		for (int i = 0;i < 5 ;i++ ) {
			System.out.print(a[i] + " ");
		}
	}
}