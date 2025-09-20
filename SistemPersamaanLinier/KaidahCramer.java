package SistemPersamaanLinier;

import java.util.Scanner;

import Determinan.EkspansiKofaktor;
import Helpers.InputMatriks;

public class KaidahCramer {
    public static void run() {
        Scanner input = new Scanner(System.in);
        double[][] matriks;

        System.out.println("\n\n~~~~~ SPL: Kaidah Cramer ~~~~~");
        System.out.println("Pilih cara input:");
        System.out.println("1. Input lewat keyboard");
        System.out.println("2. Input lewat file");
        System.out.print("Pilihan: ");

        int pil = input.nextInt();
        if (pil == 1) {
            matriks = InputMatriks.DariKeyboard(input);
        } 
        else if (pil == 2) {
            System.out.print("\nMasukkan Nama File: ");
            String NamaFile = input.next();
            matriks = InputMatriks.DariFile(NamaFile);
            if (matriks == null) return;
        } 
        else {
            System.out.println("\nMasukan Tidak Valid!");
            return;
        }

        double[] solusi = HitungVariabel(matriks);
        if (solusi != null) {
            System.out.println("\nSolusi Variabel:");
            for (int i = 0; i < solusi.length; i++) {
                System.out.printf("x%d = %.3f\n", i+1, solusi[i]);
            }
        }
    }

    private static double[] HitungVariabel(double[][] matrix) {
        int m = matrix.length;         
        int n = matrix[0].length - 1;  

        double[][] A = new double[m][n];
        double[][] B = new double[m][1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = matrix[i][j];
            }
            B[i][0] = matrix[i][n];
        }

        if (m != n) {
            System.out.println("\nKaidah Cramer hanya berlaku untuk matriks persegi!");
            return null;
        }

        double detA = EkspansiKofaktor.HitungDeterminan(A);
        if (detA == 0) {
            System.out.println("\nDeterminannya 0, sistem tidak punya solusi unik!");
            return null;
        }

        double[] X = new double[n];
        for (int i = 0; i < n; i++) {
            double[][] Ai = new double[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    Ai[r][c] = A[r][c];
                }
            }

            // Ganti kolom ke-i dengan B
            for (int r = 0; r < n; r++) {
                Ai[r][i] = B[r][0];
            }

            X[i] = EkspansiKofaktor.HitungDeterminan(Ai) / detA;
        }
        return X;
    }
}
