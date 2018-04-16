public class Main {
    public static void main(String[] args) {
        LinearSystem system = new LinearSystem();
        system.showEquation();
        double[][] matrix = system.getTriangleView();
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                System.out.print(matrix[i][k]);
            }
            System.out.println();
        }
    }
}
