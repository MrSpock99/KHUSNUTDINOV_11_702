import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int pointCount = 10;
        int bound = 10;

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            points.add(new Point(random.nextInt(21) - bound, random.nextInt(21) - bound));
        }

        try {
            FileWriter writer = new FileWriter("output.txt");
            for (Point point : points) {
                writer.append(point.toString());
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
