import java.util.Scanner;
class Program{
public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	int s = 0;
	while(true){
		int j = scanner.nextInt();
		if (j % 2 == 0){
			s += j;
		}else if (j == -1) {
			break;
		}
	}
	System.out.println(s);	
}

}	