import java.util.ArrayList;

import java.util.List;
import java.util.PriorityQueue;

/*
 *
 * Given K Sorted List merge them into a sort list
 */

public class KWayMerging {
    PriorityQueue<Node> queue;

    public KWayMerging() {
        queue = new PriorityQueue<Node>(50, new NodeComparator());
    }

    public List mergeKList(List<List<Integer>> input) {
        List<Integer> output = new ArrayList<Integer>();
        if (input == null)
            return null;
        if (input.isEmpty())
            return input;
        int[] index = new int[input.size()];
        makeHeap(input, index);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int listIndex = node.getIndexList();
            output.add(node.getData());
            if (index[listIndex] < input.get(listIndex).size()) {
                queue.add(new Node(input.get(listIndex).get(index[listIndex]),
                        listIndex));
                index[listIndex] = ++index[listIndex];
            }
        }
        return output;

    }

   /*
    * Creating an initial Heap.
    */

    private void makeHeap(List<List<Integer>> input, int[] index) {

        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).isEmpty()) {
                queue.add(new Node(input.get(i).get(0), i));
                index[i] = ++index[i];
            } else
                input.remove(i);
        }

    }

    public static void main(String[] args) {
        KWayMerging k = new KWayMerging();

        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(1);
        input1.add(5);
        input1.add(9);

        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(2);
        input2.add(4);
        input2.add(12);
        input2.add(14);

        List<Integer> input3 = new ArrayList<Integer>();
        input3.add(3);
        input3.add(7);
        input3.add(11);

        List<List<Integer>> inputA = new ArrayList<List<Integer>>();
        inputA.add(input1);
        inputA.add(input2);
        inputA.add(input3);

        System.out.println("Merged List:" + k.mergeKList(inputA));

    }

}