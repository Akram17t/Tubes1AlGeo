package Helpers;

import java.io.*;
import java.util.*;

public class InputMatriks {
    // Input matriks dari file
    public static double[][] DariFile(String filename) {
        List<double[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                double[] row = new double[parts.length];
                for (int i = 0; i < parts.length; i++)
                    row[i] = Double.parseDouble(parts[i].replace(",", "."));
                rows.add(row);
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
            return null; // atau new double[0][0] agar tidak null
        } catch (NumberFormatException e) {
            System.out.println("Format angka salah di file: " + e.getMessage());
            return null;
        }
        return rows.toArray(new double[0][]);
    }


    // Input matriks dari keyboard
    public static double[][] DariKeyboard(Scanner sc) {
        System.out.print("Masukkan jumlah baris: ");
        int m = sc.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        int n = sc.nextInt();

        double[][] mat = new double[m][n];
        System.out.println("Masukkan elemen matriks baris per baris:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextDouble();
            }
        }
        return mat;
    }
}
