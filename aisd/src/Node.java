public class Node {
    Integer data;
    Integer fromListIndex;

    public Node(int data, int indexList) {
        this.data = data;
        this.fromListIndex = indexList;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getIndexList() {
        return fromListIndex;
    }

    public void setIndexList(int indexList) {
        this.fromListIndex = indexList;
    }

}