import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void isTreeBySufficientCondition1() {
        int[][] m = {{0, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        Graph graph = new Graph(m);

        Assert.assertTrue(graph.isTreeBySufficientCondition());

    }

    @Test
    public void isTreeBySufficientCondition2() {
        int[][] m = {{0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};
        Graph graph = new Graph(m);

        Assert.assertFalse(graph.isTreeBySufficientCondition());
    }

    @Test
    public void isTreeByDfs1() {
        int[][] m = {{0, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        Graph graph = new Graph(m);

        Assert.assertTrue(graph.isTreeByDfs());

    }

    @Test
    public void isTreeByDfs2() {
        int[][] m = {{0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};
        Graph graph = new Graph(m);

        Assert.assertFalse(graph.isTreeByDfs());

    }

    @Test
    public void isTreeByDfs3() {
        int[][] m = {{0, 1, 1}, {0, 0, 1}, {0, 1, 0}};
        Graph graph = new Graph(m);

        Assert.assertFalse(graph.isTreeByDfs());

    }

    @Test
    public void isTreeByDfs4() {
        int[][] m = {{0, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0, 0,}};
        Graph graph = new Graph(m);

        Assert.assertTrue(graph.isTreeByDfs());

    }

    @Test
    public void isTreeByDfs5() {
        int[][] m = {{0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(m);

        Assert.assertTrue(graph.isTreeByDfs());

    }

    @Test
    public void isTreeByDfs6() {
        int[][] m = {{0,1,1,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        Graph graph = new Graph(m);

        Assert.assertFalse(graph.isTreeByDfs());

    }
}