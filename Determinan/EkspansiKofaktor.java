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
            String NamaFile = input.next()
            matriks = InputMatriks.DariFile(NamaFile);
        }
        else {
            System.out.println("Masukan Tidak Valid!");
        }

    }
}
