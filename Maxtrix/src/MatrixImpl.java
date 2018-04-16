import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatrixImpl implements Matrix {
    private Map<Integer[],Integer> mapElements = new HashMap<>();
    private ArrayList<Element> elements = new ArrayList();
    @Override
    public void set(int i, int j, int value) {
        mapElements.put(new Integer[]{i,j},value);
        elements.add(new Element(i,j,value));
    }

    @Override
    public int get(int i, int j) {
        Element el = new Element(i,j);
        for (int k = 0; i < elements.size(); k++){
            if (el.equals(elements.get(i)))
        }
        return mapElements.getOrDefault(cor, -1);
    }

    public Map<Integer[], Integer> getMapElements() {
        return mapElements;
    }
}
