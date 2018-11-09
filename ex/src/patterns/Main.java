package patterns;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("input.txt");
        int b = 0;
        while (b != -1){
            b = inputStream.read();
            System.out.print((char)(b));
        }
        System.out.println();
        System.out.println("------------------");
        Reader reader = new InputStreamReader(new FileInputStream("input.txt"),"utf-8");

        b = 0;
        while (b != -1){
            b = reader.read();
            System.out.print((char)(b));
        }
    }
}
