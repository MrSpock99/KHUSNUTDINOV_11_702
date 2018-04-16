import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        System.out.println(check(strings));

    }

    public static boolean check(String[] strings) {
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (threeQ(strings[i]) || fiveZ(strings[i])) {
                count++;
            }
        }
        return count >= 2;
    }

    public static boolean threeQ(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'q') {
                count++;
            }
            if (count > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean fiveZ(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'z') {
                count++;
            }
            if (count > 5) {
                return false;
            }
        }
        return true;
    }
}
