import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge> edges;
    private int[] graphArr;

    public int[] getGraphArr() {
        return graphArr;
    }

    private int vertexCount;
    public Graph(LinkedList<Edge> edges){
        this.edges = edges;
        graphArr = new int[getSize()];
        for (int i = 0; i < graphArr.length; i++){
            graphArr[i] = -1;
        }
        buildGraphArray();
    }

    private void buildGraphArray() {
        for (Edge edge : edges){
            graphArr[edge.getX()] = graphArr[edge.getX()] == -1 ? 1 : graphArr[edge.getX()] + 1;
        }
        int vertexIndex = vertexCount;
        for (int i = 0; i < vertexCount; i++){
            if (graphArr[i] != -1){
                int edgesCount = graphArr[i];
                graphArr[i] = vertexIndex;
                vertexIndex += edgesCount;
            }
        }
        for (Edge edge : edges){
            if (graphArr[graphArr[edge.getX()]] != -1){
                int emptyPlace = graphArr[edge.getX()] + 1;
                while (graphArr[emptyPlace] != -1){
                    emptyPlace++;
                }
                graphArr[emptyPlace] = edge.getY();
            }else {
                graphArr[graphArr[edge.getX()]] = edge.getY();
            }
        }
    }

    public void printArray(){
        System.out.println(Arrays.toString(graphArr));
    }

    public void printGraph(){
        for (int i = 0; i < vertexCount; i++){
            if (graphArr[i] != -1){
                System.out.print("Вершина " + i +": ");
                int begin = graphArr[i];
                int end = i + 1;
                while (graphArr[end] == -1 && end < vertexCount){
                    end++;
                }
                end = end == vertexCount ? graphArr.length : graphArr[end];
                for (int j = begin; j < end; j++){
                    System.out.print(graphArr[j] + " ");
                }
                System.out.println();
            }
        }
    }

    private int getSize(){
        int max = -1;
        for (Edge edge : edges){
            if (edge.getMax() >= max){
                max = edge.getMax();
            }
        }
        vertexCount = max + 1;
        return max + edges.size() + 1;
    }
}
