import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Graph {
    private int[][] matrix;
    private Node root;
    private ArrayList<Node> nodes;
    private boolean isTree = true;

    public Graph(int[][] matrix) {
        nodes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            Node node = new Node(i);
            if (nodes.contains(node)) {
                node = nodes.get(nodes.indexOf(node));
            }
            for (int k = 0; k < matrix.length; k++) {
                Node child = new Node(k);
                if (nodes.contains(child)) {
                    child = nodes.get(nodes.indexOf(child));
                }
                if (matrix[i][k] == 1) {
                    node = addChild(node, child);
                    if (nodes.contains(child)) {
                        nodes.set(nodes.indexOf(child), child);
                    } else {
                        nodes.add(child);
                    }
                }
            }
            if (nodes.contains(node)) {
                nodes.set(nodes.indexOf(node), node);
            } else {
                nodes.add(node);
            }

            for (Node node1 : nodes) {
                if (node1.parent == null) {
                    root = node1;
                    break;
                }
            }
        }
        this.matrix = matrix;
    }


    public boolean isTreeBySufficientCondition() {
        int edgesCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[i][k] == 1) {
                    edgesCount++;
                }
            }
        }

        return edgesCount == matrix.length - 1;
    }

    public boolean isTreeByDfs() {
        dfs(root);
        for (Node node : nodes) {
            if (!node.isMarked) {
                isTree = false;
                return false;
            }
        }
        return isTree;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (root.isMarked) {
            isTree = false;
            return;
        }
        root.isMarked = true;
        for (Node node : root.childs) {
            dfs(node);
        }
    }

    private Node addChild(Node root, Node child) {
        child.parent = root;
        root.childs.add(child);
        /*if (root.left == null){
            root.left = child;
            root.left.parent = root;
        }else if (root.right == null){
            root.right = child;
            root.right.parent = root;
        }*/
        return root;
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private boolean isMarked;
        private int num;
        private Deque<Node> childs;

        Node(int num) {
            childs = new LinkedList<>();
            this.num = num;
            isMarked = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return this.num == node.num;
        }

        @Override
        public int hashCode() {
            int result = left != null ? left.hashCode() : 0;
            result = 31 * result + (right != null ? right.hashCode() : 0);
            result = 31 * result + (parent != null ? parent.hashCode() : 0);
            result = 31 * result + (isMarked ? 1 : 0);
            result = 31 * result + num;
            return result;
        }
    }
}
