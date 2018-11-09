import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(3,6));
        edges.add(new Edge(1,4));
        edges.add(new Edge(1,2));
        edges.add(new Edge(6,4));
        edges.add(new Edge(6,5));

        Graph graph = new Graph(edges);
        graph.printArray();
        graph.printGraph();
    }
}
