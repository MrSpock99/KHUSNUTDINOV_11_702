import java.io.Serializable;
import java.util.ArrayList;

public class SimpleMatrix<N extends Number> implements Matrix<N>,Serializable{
    private ArrayList<ArrayList<N>> arr;

    public SimpleMatrix(ArrayList<ArrayList<N>> arr){
        this.arr = arr;
    }

    @Override
    public void transpose() {

    }

    @Override
    public Matrix<N> multiply(Matrix m) {
        return null;
    }

    @Override
    public Matrix<N> subtract(Matrix m) {
        return null;
    }

    public ArrayList<ArrayList<N>> getArr(){
        return arr;
    }

}
