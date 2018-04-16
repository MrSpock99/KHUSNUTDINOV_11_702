import java.util.*;

public class RandomTree {
    private Node unOptimizedNode;
    private ArrayList<Node> nodes;
    private int maxChildCount;
    private ArrayList<Integer> exclude;
    private int count;

    public RandomTree(int maxChildCount) {
        if (maxChildCount <= 0) {
            throw new IllegalArgumentException("k should be > 0!");
        }
        nodes = new ArrayList<>();
        this.maxChildCount = maxChildCount;

    }

    class Node {
        private int index;
        private int parentIndex;

        private ArrayList<Node> childs;

        Node(int index, int parentIndex) {
            this.index = index;
            this.parentIndex = parentIndex;
            childs = new ArrayList<>();
            exclude = new ArrayList<>();
            exclude.add(0);
        }

        void addChild(Node node) {
            childs.add(node);
        }
    }


    public void setTree(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            Node node = new Node(i, list.get(i));
            nodes.add(node);
            exclude.add(i);
        }
        for (int i = 0; i < nodes.size(); i++) {
            Node parent = nodes.get(i);
            for (int k = 0; k < nodes.size(); k++) {
                if (nodes.get(k).parentIndex == parent.index && i != k) {
                    parent.addChild(nodes.get(k));
                }

            }
        }
    }

    int optimize() {
        if (!isOptimized()) {
            ArrayList<Node> childs = unOptimizedNode.childs;

            childs.sort((o1, o2) -> Integer.compare(o1.childs.size(), o2.childs.size()));

            unOptimizedNode.childs = new ArrayList<>();

            int generatedIndex = Utils.getRandomWithExclusion(new Random(), 1, 100, exclude);
            exclude.add(generatedIndex);

            Node node = new Node(generatedIndex, unOptimizedNode.index);
            Iterator<Node> iterator = childs.iterator();
            int c = 0;
            while (iterator.hasNext()) {
                c++;
                Node n = iterator.next();
                node.addChild(n);
                iterator.remove();
                if (c >= maxChildCount) {
                    break;
                }
            }

            unOptimizedNode.addChild(node);
            iterator = childs.iterator();

            c = 0;
            while (iterator.hasNext()) {
                c++;
                Node n = iterator.next();
                unOptimizedNode.addChild(n);
            }
            count++;
            optimize();
        }
        return count;
    }

    boolean isOptimized() {
        for (Node node : nodes) {
            if (node.childs.size() > maxChildCount) {
                unOptimizedNode = node;
                return false;
            }
        }
        return true;
    }


}