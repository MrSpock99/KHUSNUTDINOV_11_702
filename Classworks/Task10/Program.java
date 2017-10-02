import java.util.Scanner;
import java.lang.Math;

class Program{
	public static boolean isPrime(int number){
		if (number <= 3 && number > 1) {
			return true;
		}else{
			for (int i = 2;i <= Math.pow(number,0.5);i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();

		boolean prime = isPrime(x);

		System.out.println(prime);
	}
}