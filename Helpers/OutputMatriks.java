package Helpers;

public class OutputMatriks {
    public static void print(double[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] colWidths = new int[cols];
        for (int j = 0; j < cols; j++) {
            int maxWidth = 0;
            for (int i = 0; i < rows; i++) {
                String s = String.format("%.3f", mat[i][j]);
                if (s.length() > maxWidth) maxWidth = s.length();
            }
            colWidths[j] = maxWidth;
        }

        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                String s = String.format("%" + colWidths[j] + ".3f", mat[i][j]);
                System.out.print(" " + s);
            }
            System.out.println(" |");
        }
    }
}
