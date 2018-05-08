import java.io.Serializable;

public interface Matrix<N extends Number>{
    void transpose();
    Matrix<N> multiply(Matrix<N> m);
    Matrix<N> subtract(Matrix<N> m);
}
