import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Utils {
    public static int getRandomWithExclusion(Random rnd, int start, int end, ArrayList<Integer> exclude) {
        Collections.sort(exclude);
        int random = start + rnd.nextInt(end - start + 1 - exclude.size());
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
}
