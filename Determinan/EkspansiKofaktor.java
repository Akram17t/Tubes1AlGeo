package Determinan;

import Helpers.InputMatriks;
import Helpers.OutputMatriks;
import java.util.Scanner;

public class EkspansiKofaktor {
    public static void run() {
        Scanner input = new Scanner(System.in);
        double[][] matriks;
        
        System.out.println("~~~~~ Determinan: Ekspansi Kofaktor ~~~~~");
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

        System.out.println("\nMatriks:");
        OutputMatriks.print(matriks);
        
        double Hasil = HitungDeterminan(matriks);
        System.out.printf("\nDeterminan Matriks: %.3f", Hasil);

        System.out.println("\n\n\n");

    }

    public static double HitungDeterminan(double[][] matrix){
        int n = matrix.length;

        if (n == 1){
            return matrix[0][0];
        }
        else if (n == 2){
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix [1][0];
        }
        else {
            double total = 0;
            for (int i = 0; i < n; i++){
                double[][] minor = Minor(matrix, 0, i);
                double kali = 1.0;
                if (i % 2 == 1) kali *= (-1.0);
                total += kali * HitungDeterminan(minor) * matrix[0][i];
            }
            return total;
        }

    }

    public static double[][] Minor(double[][] matrix, int x, int y){
        int n = matrix.length;
        double[][] matrixMinor = new double[n-1][n-1];
        int r = 0, c = 0;
        for (int i = 0; i < n; i++){
            if (i == x) continue;
            else {
                c = 0;
                for (int j = 0; j < n; j++){
                    if (j == y) continue;
                    else {
                        matrixMinor[r][c] = matrix[i][j];
                        c++;
                    }
                }
            }
            r++;
        }
        return matrixMinor;
    }
}
