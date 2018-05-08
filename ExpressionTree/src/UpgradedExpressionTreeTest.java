import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpgradedExpressionTreeTest {

    @Test
    public void calculate1(){
        String input = "2 + 2";
        UpgradedExpressionTree tree = new UpgradedExpressionTree(input);

        int expected = 4;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate2() throws Exception {
        String input = "2 + 2 * 4";
        UpgradedExpressionTree tree = new UpgradedExpressionTree(input);

        int expected = 10;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void calculate3() throws Exception {
        String input = "2 * 2 + 4";
        UpgradedExpressionTree tree = new UpgradedExpressionTree(input);

        int expected = 8;
        int actual = tree.calculate();

        Assert.assertEquals(expected,actual);
    }


}