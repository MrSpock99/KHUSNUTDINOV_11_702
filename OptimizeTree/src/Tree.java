public interface Tree<T extends Comparable<T>> {
    void insert(T value);
    boolean remove(T value);
    void print();
    boolean contains(T value);
    void printByLevels();
    boolean isBst();
}
