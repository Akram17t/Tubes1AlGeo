package InversMatriks;
import java.util.Scanner;

import Determinan.EkspansiKofaktor;
import Helpers.InputMatriks;
import Helpers.OutputMatriks;

public class MetodeAdjoin {

    public static void run() {
        Scanner input = new Scanner(System.in);
        double[][] matriks;
        
        System.out.println("\n\n~~~~~ Invers: Metode Adjoin ~~~~~");
        System.out.println("Pilih cara input:");
        System.out.println("1. Input lewat keyboard");
        System.out.println("2. Input lewat file");
        System.out.print("Pilihan: ");

        int pil = input.nextInt();
        if (pil == 1) {
            matriks = InputMatriks.DariKeyboard(input);
        }
        else if (pil == 2) {
            System.out.print("Masukkan Nama File");
            String NamaFile = input.next();
            matriks = InputMatriks.DariFile(NamaFile);
            if (matriks == null) return;
        }
        else {
            System.out.println("Masukan Tidak Valid!");
            return;
        }
        
        double det = EkspansiKofaktor.HitungDeterminan(matriks);
        double [][] MatriksKofaktor = Kofaktor(matriks);
        double [][] MatriksAdjoin = Adjoin(MatriksKofaktor);
        double [][] MatriksInvers = Invers(MatriksAdjoin, det);

        System.out.println("\nHasil Matriks Invers:");
        OutputMatriks.print(MatriksInvers);
        System.out.println("\n\n\n");

    }

    private static double[][] Kofaktor(double[][] matrix){
        int n = matrix.length;
        double [][] Kof = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                double [][] mat = EkspansiKofaktor.Minor(matrix, i, j);
                double kali = 1.0;
                if ((i + j) % 2 == 1) kali *= (-1.0);
                Kof[i][j] = kali * EkspansiKofaktor.HitungDeterminan(mat);
            }
        }
        System.out.println("\n\nMatriks Kofaktor:");
        OutputMatriks.print(Kof);
        System.out.println("\n");
        return Kof;
    }

    private static double[][] Adjoin(double[][] matrix){
        int n = matrix.length;
        double [][] Adj = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Adj[i][j] = matrix[j][i];
            }
        }
        System.out.println("\nMatriks Adjoin:");
        OutputMatriks.print(Adj);
        System.out.println("\n");
        return Adj;
    }

    private static double[][] Invers(double[][] matrix, double det){
        int n = matrix.length;
        double [][] Inv = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Inv[i][j] = matrix[i][j] / det;
            }
        }
        return Inv;
    }
}
