import java.util.Scanner;
class Program{
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int sum = 5050;
		 int calculatedSum = 0;
		 for (int i = 0;i < 99;i++) {
		 	int input = scanner.nextInt();
		 	calculatedSum += input;
		 }

		 int res = sum - calculatedSum;

		 System.out.println(res);
	}
}