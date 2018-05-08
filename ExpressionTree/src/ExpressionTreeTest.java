import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTreeTest {
    @Test
    public void calculate1() throws Exception {
        String input = "( ( 1 + 2 ) + ( 3 + 4 ) )";
        ExpressionTree tree = new ExpressionTree(input);

        int expected = 10;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate2() throws Exception {
        String input = "( 2 + 2 )";
        ExpressionTree tree = new ExpressionTree(input);

        int expected = 4;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate3() throws Exception {
        String input = "( 2 / 2 )";
        ExpressionTree tree = new ExpressionTree(input);

        int expected = 1;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate4() throws Exception {
        String input = "( ( 2 / 2 ) + 3 )";
        ExpressionTree tree = new ExpressionTree(input);

        int expected = 4;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate5() throws Exception {
        String input = "( ( ( ( 2 + 4 ) * 7 ) + ( 3 * 4 ) ) - 2 )";
        ExpressionTree tree = new ExpressionTree(input);

        int expected = 52;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate6() throws Exception {
        String input = "( 22 + 3 )";
        ExpressionTree tree = new ExpressionTree(input);

        int expected = 25;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

}