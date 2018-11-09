package patterns.decorator;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new BufferedInputStream(new LogInputStream((new FileInputStream("input.txt"))));
        while (inputStream.read() != -1){
            System.out.println(1);
        }
    }
}
