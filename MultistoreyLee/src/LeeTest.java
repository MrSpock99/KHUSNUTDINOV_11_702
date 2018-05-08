import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

public class LeeTest {

    @Test
    public void getPath1(){
        int[][] floor1 = {{0,-2,-2},{-1,-2,-1},{-2,-1,-2}};
        int[][] floor2 = {{-1,-2,-1},{-1,-2,-1},{-1,-2,-2}};
        int[][] floor3 = {{-1,-1,-1},{-2,-2,-2},{-1,-1,-1}};
        ArrayList<int[][]> maze = new ArrayList<>();
        maze.add(floor1);
        maze.add(floor2);
        maze.add(floor3);
        Lee lee = new Lee(maze);

        ArrayList<Point> actual = lee.getPath(new Point(0,0,0), new Point(2,2,2));
        Collections.reverse(actual);

        ArrayList<Point> expected = new ArrayList<>();
        expected.add(new Point(0, 0, 0));
        expected.add(new Point(1, 0, 0));
        expected.add(new Point(1, 1, 0));
        expected.add(new Point(1, 2, 0));
        expected.add(new Point(2, 2, 0));
        expected.add(new Point(2, 2, 1));
        expected.add(new Point(2 , 2, 2));

        Assert.assertEquals(expected,actual);
    }


}