package Helpers;

public class OutputMatriks {
    // Print matriks rapi
    public static void print(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row) {
                System.out.printf("%8.3f", val);
            }
            System.out.println();
        }
    }
}
