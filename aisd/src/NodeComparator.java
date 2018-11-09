import java.util.Comparator;

public class NodeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Node n1 = (Node)o1;
        Node n2 = (Node)o2;

        return n1.getData().compareTo(n2.getData());
    }
}