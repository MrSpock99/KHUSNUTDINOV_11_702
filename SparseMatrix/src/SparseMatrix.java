import java.io.Serializable;
import java.util.ArrayList;

public class SparseMatrix<N extends Number> implements Matrix<N>,Serializable{
    private Node head;
    private Node tail;
    private int count;
    private SimpleMatrix<N> simpleMatrix;

    public SparseMatrix() {

    }

    private class Node implements Serializable{
        private N value;
        private int x;
        private int y;

        private Node next;
        private Node prev;

        Node(int x, int y, N value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        Node() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return x == node.x && y == node.y &&  node.value.equals(value);
        }

        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            result = 31 * result + x;
            result = 31 * result + y;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            result = 31 * result + (prev != null ? prev.hashCode() : 0);
            return result;
        }
    }

    public SparseMatrix(SimpleMatrix<N> matrix) {
        simpleMatrix = matrix;
        ArrayList<ArrayList<N>> arr = matrix.getArr();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(0).size(); j++) {
                if (!arr.get(i).get(j).equals(0) && !arr.get(i).get(j).equals(0.0)) {
                    Node node = new Node(i, j, arr.get(i).get(j));
                    if (head == null) {
                        head = node;
                        tail = node;
                    } else {
                        node.prev = tail;
                        tail.next = node;
                        tail = node;
                    }
                    count++;
                }
            }
        }
    }

    @Override
    public void transpose() {
        Node node = head;
        do {
            int c = node.x;
            node.x = node.y;
            node.y = c;
            node = node.next;
        } while (node.next != null);

    }

    @Override
    public Matrix<N> multiply(Matrix<N> m) {
        if (m instanceof SparseMatrix) {
            SparseMatrix<N> matrix = ((SparseMatrix<N>) m);
            Node mNode = matrix.getHead();
            Node node = head;
            Node res = new Node();
            SparseMatrix<N> resMatrix = new SparseMatrix<>();

            while (node != null){
                while (mNode != null) {

                    if (mNode.x == node.y) {
                        N mulRes = multiply(mNode.value, node.value);
                        res.x = node.x;
                        res.y = mNode.y;
                        if (resMatrix.contains(res)){
                            res = resMatrix.get(res);
                            res.value = sum(res.value, mulRes);
                        }else {
                            res.value = mulRes;
                        }
                        if (!resMatrix.contains(res)){
                            resMatrix.add(res);
                        }else {
                            resMatrix.replace(res);
                        }
                        res = new Node();
                    }

                    mNode = mNode.next;
                }

                node = node.next;
                mNode = matrix.getHead();
            }

            return resMatrix;
        } else {

        }
        return null;
    }

    private void replace(Node node) {
        Node mNode = get(node);
        Node newNode = new Node(mNode.x,mNode.y,mNode.value);

        newNode.prev = mNode.prev;
        newNode.next = mNode.next;
        newNode.value = mNode.value;
    }

    private Node get(Node node) {
        Node mNode = head;
        while (mNode != null) {
            if (mNode.x == node.x && mNode.y == node.y) {
                return mNode;
            }
            mNode = mNode.next;
        }
        return null;
    }

    public void add(Node node){
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public boolean contains(Node node){
        Node mNode = head;
        while (mNode != null) {
            if (mNode.x == node.x && mNode.y == node.y) {
                return true;
            }
            mNode = node.next;
        }
        return false;
    }

    private N multiply(N a, N b) {
        if (a instanceof Double || b instanceof Double) {
            return (N) new Double(a.doubleValue() * b.doubleValue());
        } else {
            return (N) new Integer(a.intValue() * b.intValue());
        }
    }

    private N subtract(N a, N b) {
        if (a instanceof Double || b instanceof Double) {
            if (a == null){
                return (N) new Double(b.doubleValue());
            }else if (b == null){
                return (N)new Double(a.doubleValue());
            }
            return (N) new Double(a.doubleValue() - b.doubleValue());
        } else {
            if (a == null){
                return (N) new Integer(b.intValue());
            }else if (b == null){
                return (N)new Integer(b.intValue());
            }
            return (N) new Integer(a.intValue() - b.intValue());
        }
    }

    private N negate(N a){
        if (a instanceof Double) {
            return (N) new Double(-a.doubleValue());
        } else {
            return (N) new Integer(-a.intValue());
        }
    }

    private N sum(N a, N b) {
        if (a instanceof Double || b instanceof Double) {
            if (a == null){
                return (N) new Double(b.doubleValue());
            }else if (b == null){
                return (N)new Double(a.doubleValue());
            }
            return (N) new Double(a.doubleValue() + b.doubleValue());
        } else {
            if (a == null){
                return (N) new Integer(b.intValue());
            }else if (b == null){
                return (N)new Integer(b.intValue());
            }
            return (N) new Integer(a.intValue() + b.intValue());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;

        SparseMatrix<N> matrix = (SparseMatrix<N>)obj;

        if (matrix.count != this.count)return false;

        Node node = head;
        Node mNode = matrix.getHead();

        boolean flag = false;
        while (node != null){
            while (mNode != null){
                if (node.equals(mNode)){
                    flag = true;
                    break;
                }
                mNode = mNode.next;
            }
            if (!flag)return false;

            node = node.next;
            mNode = matrix.getHead();
        }
        return true;
    }

    @Override
    public Matrix<N> subtract(Matrix<N> m) {
        if (m instanceof SparseMatrix){

            SparseMatrix<N> matrix = (SparseMatrix<N>)m;
            if (simpleMatrix.getArr().size() != matrix.getSimpleMatrix().getArr().size() || simpleMatrix.getArr().get(0).size() != matrix.getSimpleMatrix().getArr().get(0).size()){
                throw new IllegalArgumentException("Sizes must be equal!");
            }

            SparseMatrix<N> resMatrix = new SparseMatrix<>();

            Node mNode = matrix.getHead();
            Node node = head;
            Node res = new Node();
            boolean wasMatch = false;
            while (node != null){
                while (mNode != null){
                    if (node.x == mNode.x && node.y == mNode.y){
                        N val = subtract(node.value,mNode.value);
                        if (!val.equals(0.0) && !val.equals(0)){
                            res.value = val;
                            res.x = node.x;
                            res.y = node.y;
                            resMatrix.add(res);
                        }
                        wasMatch = false;
                        break;
                    }else {
                        wasMatch = true;
                    }

                    mNode = mNode.next;
                }
                if (wasMatch){
                    res.value = node.value;
                    res.x = node.x;
                    res.y = node.y;
                    resMatrix.add(res);
                    wasMatch = false;
                }

                res = new Node();
                node = node.next;
                mNode = matrix.getHead();
            }
            while (mNode != null){
                node = get(mNode);
                if (node == null){
                    res.x = mNode.x;
                    res.y = mNode.y;
                    res.value = negate(mNode.value);
                    resMatrix.add(res);
                }
                mNode = mNode.next;
            }
        return resMatrix;
        }
        return null;
    }


    public Node getHead() {
        return head;
    }

    public SimpleMatrix<N> getSimpleMatrix(){
        return simpleMatrix;
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder builder = new StringBuilder();
        while (node != null){
            builder.append("(").append(node.x).append(", ").append(node.y).append(", ").append(node.value).append(")");
            node = node.next;
        }
        return builder.toString();
    }
}
