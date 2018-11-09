import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testBuildGraphArray1(){
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(3,6));
        edges.add(new Edge(1,4));
        edges.add(new Edge(1,2));
        edges.add(new Edge(6,4));
        edges.add(new Edge(6,5));

        Graph actual = new Graph(edges);
        int[] expected = {-1, 7, -1, 9, -1, -1, 10, 4, 2, 6, 4, 5};

        Assert.assertArrayEquals(expected,actual.getGraphArr());
    }
    @Test
    public void testBuildGraphArray2(){
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(1,2));
        edges.add(new Edge(0,4));
        edges.add(new Edge(5,7));
        edges.add(new Edge(0,3));

        Graph actual = new Graph(edges);
        int[] expected = {8,10,-1,-1,-1,11,-1,-1,4,3,2,7};

        Assert.assertArrayEquals(expected,actual.getGraphArr());
    }

    @Test
    public void testBuildGraphArray3(){
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(4,0));
        edges.add(new Edge(4,1));
        edges.add(new Edge(4,2));
        edges.add(new Edge(4,3));

        Graph actual = new Graph(edges);
        int[] expected = {-1,-1,-1,-1,5,0,1,2,3};

        Assert.assertArrayEquals(expected,actual.getGraphArr());
    }

    @Test
    public void testBuildGraphArray4(){
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(6,6));
        edges.add(new Edge(4,9));
        edges.add(new Edge(8,1));
        edges.add(new Edge(4,7));
        edges.add(new Edge(8,2));
        edges.add(new Edge(6,4));
        edges.add(new Edge(8,4));

        Graph actual = new Graph(edges);
        int[] expected = {-1,-1,-1,-1,10,-1,12,-1,14,-1,9,7,6,4,1,2,4};

        Assert.assertArrayEquals(expected,actual.getGraphArr());
    }



}