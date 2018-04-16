import java.util.Arrays;

import static java.lang.Math.abs;

public class LinearSystem {

    double[][] matrix = new double[4][4];

    public LinearSystem(double[][] matrix) {
        this.matrix = matrix;
    }

    public LinearSystem() {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[i][k] = 1;
            }
        }
    }

    public double[] getSolution() {
        double[][] x1Matrix = getX1Matrix(matrix);
        double x1 = det(x1Matrix) / det(matrix);

        double[][] x2Matrix = getX2Matrix(matrix);
        double x2 = det(x2Matrix) / det(matrix);

        double[][] x3Matrix = getX3Matrix(matrix);
        double x3 = det(x3Matrix) / det(matrix);

        return new double[]{x1, x2, x3};
    }

    private double[][] getX3Matrix(double[][] m) {
        m[0][2] = m[0][3];
        m[1][2] = m[1][3];
        m[2][2] = m[2][3];

        return m;
    }

    private double[][] getX2Matrix(double[][] m) {
        m[0][1] = m[0][3];
        m[1][1] = m[1][3];
        m[2][1] = m[2][3];

        return m;
    }

    private double[][] getX1Matrix(double[][] m) {
        m[0][0] = m[0][3];
        m[1][0] = m[1][3];
        m[2][0] = m[2][3];

        return m;
    }

    public void showEquation() {
        int k = 1;
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][0] != 0) {
                System.out.print(matrix[i][0] + "x" + k);
            }
            k++;
            if (matrix[i][1] != 0) {
                if ((matrix[i][1] > 0) && (matrix[i][0] > 0)) {
                    System.out.print(" + ");
                }
                System.out.print(matrix[i][1] + "x" + k);
            }
            k++;
            if (matrix[i][2] != 0) {
                if ((matrix[i][2] > 0) && ((matrix[i][0] > 0) || (matrix[i][1] > 0))) {
                    System.out.print(" + ");
                }
                System.out.print(matrix[i][2] + "x" + k);
            }

            System.out.println("= " + matrix[0][3]);
            k = 1;
        }

    }

    public double[][] getTriangleView() {

        double[][] triangleMatrix = new double[matrix.length][matrix.length];
        for (int i =0 ; i < matrix.length; i++){
            triangleMatrix[i] = matrix[i];
        }

        double v;
        int row = 0;
        int k = 0;
        while (k < matrix.length - 1) {
            int i, j;
            int gr = row;
            for (i = row + 1; i < matrix.length; i++) {
                if (abs(triangleMatrix[row][k]) < abs(triangleMatrix[i][k]))
                    gr = i;
            }

            if ((row == gr) && (triangleMatrix[row][k] == 0)) {
                k++;
                continue;
            }


            if (row != gr) {
                for (j = 0; j < matrix.length; j++) {

                    v = triangleMatrix[row][j];
                    triangleMatrix[row][j] = triangleMatrix[gr][j];
                    triangleMatrix[gr][j] = v;
                }

            }


            for (i = row + 1; i < matrix.length; i++) {

                v = 1.0 * triangleMatrix[i][k] / triangleMatrix[row][k];
                triangleMatrix[i][k] = 0;
                if (v != 0)
                    for (j = k + 1; j < matrix.length; j++)
                        triangleMatrix[i][j] = triangleMatrix[i][j] - v * triangleMatrix[k][j];

            }
            row++;
            k++;
        }
        return triangleMatrix;

    }

    private double det(double[][] koeficients) {
        return koeficients[0][0] * koeficients[1][1] * koeficients[2][2] +
                koeficients[0][1] * koeficients[1][2] * koeficients[2][0] +
                koeficients[0][2] * koeficients[1][0] * koeficients[2][1] -
                koeficients[0][2] * koeficients[1][1] * koeficients[2][0] -
                koeficients[0][0] * koeficients[1][2] * koeficients[2][1] -
                koeficients[0][1] * koeficients[1][0] * koeficients[][1];

    }


}
