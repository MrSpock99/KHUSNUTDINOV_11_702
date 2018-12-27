import utils.SentimentAnalyzer;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainSentiment {
    public static void main(String[] args) throws IOException {
        FileInputStream inFile = new FileInputStream("tweets_quarter_1.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str, StandardCharsets.UTF_8);

        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        String analisis = (sentimentAnalyzer.analyze(text));

        FileWriter fileWriter = new FileWriter("sentiment.txt");

        fileWriter.write(analisis);

        fileWriter.close();
    }
}
