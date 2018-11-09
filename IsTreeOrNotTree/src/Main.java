public class Main {
    public static void main(String[] args) {
        int[][] m = {{0,1,1,0,0},{0,0,0,1,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        int[][] m1 = {{0,1,1,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,1},{0,0,0,0,0}};
        Graph graph = new Graph(m);
        System.out.println(graph.isTreeBySufficientCondition());
    }
}
