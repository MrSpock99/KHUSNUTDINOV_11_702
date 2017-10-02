import java.util.Scanner;
class Program{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Для простоты максимальный и минимальный элементы последовательности будут 1000 и -1000 		
		int max = -1001;
		int min = 1001;

		while(true){
			int j = scanner.nextInt();
			if (j == -1){
				break;
			}
			if (j > max){
				max = j;
			}
			if (j < min){
				min = j;
			}
		}

		System.out.println("Разница = " + (max - min));
	}
}