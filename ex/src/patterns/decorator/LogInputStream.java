package patterns.decorator;

import java.io.IOException;
import java.io.InputStream;

public class LogInputStream extends InputStream{
    private InputStream inputStream;

    public LogInputStream(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        System.out.println("Read 1 byte");
        return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        System.out.println("Read " + b.length + " bytes");
        return inputStream.read(b);
    }
}
