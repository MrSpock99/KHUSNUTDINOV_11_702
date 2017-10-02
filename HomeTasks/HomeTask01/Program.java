import java.util.Scanner;
class Program{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int p = 1;
		int sum = 0;
		while (true){
			int j = scanner.nextInt();
			if (j == - 1) {
				break;
			}
			if (isEven(j)) {
				p *= j;
			}
			if (endsWithSeven(j)) {
				sum += j;
			}
		}

		System.out.println("p = " + p);
		System.out.println("sum = " + sum);

	}

	private static boolean isEven(int n){
		int sum = 0;
		while(n > 0){
			int k = n % 10;
			sum += k;
			n /= 10;	
		}
			return sum % 2 == 0;
		
	}

	private static boolean endsWithSeven(int n){
		int k = n % 10;
		if (k == 7){
			return true;
		}else{
			return false;
		}
	}
}