import java.util.Scanner;

// import semua modul
// import SistemPersamaanLinier.EliminasiGauss;
// import SistemPersamaanLinier.EliminasiGaussJordan;
// import SistemPersamaanLinier.KaidahCramer;
// import SistemPersamaanLinier.MetodeMatriksBalikan;

import Determinan.EkspansiKofaktor;
// import Determinan.ReduksiBaris;

import InversMatriks.MetodeAdjoin;
// import InversMatriks.MetodeAugment;

// import Interpolasi.Polinomial;
// import Interpolasi.SplinaBezierKubik;

// import RegresiPolinomialBerganda.RegresiPolinomial;

public class MenuUtama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan Matriks");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi");
            System.out.println("5. Regresi Polinomial Berganda");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1: menuSPL(sc); break;
                case 2: menuDeterminan(sc); break;
                case 3: menuInvers(sc); break;
                case 4: menuInterpolasi(sc); break;
                case 5: menuRegresi(sc); break;
                case 0: System.out.println("Program selesai. Terima kasih."); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);

        sc.close();
    }

    private static void menuSPL(Scanner sc) {
        System.out.println("\n--- Sistem Persamaan Linier ---");
        System.out.println("1. Eliminasi Gauss");
        System.out.println("2. Eliminasi Gauss-Jordan");
        System.out.println("3. Kaidah Cramer");
        System.out.println("4. Matriks Balikan");
        System.out.print("Pilih metode: ");
        int m = sc.nextInt();

        switch (m) {
            // case 1: EliminasiGauss.run(); break;
            // case 2: EliminasiGaussJordan.run(); break;
            // case 3: KaidahCramer.run(); break;
            // case 4: MetodeMatriksBalikan.run(); break;
            default: System.out.println("Pilihan tidak valid!");
        }
    }

    private static void menuDeterminan(Scanner sc) {
        System.out.println("\n--- Determinan Matriks ---");
        System.out.println("1. Ekspansi Kofaktor");
        System.out.println("2. Reduksi Baris (OBE)");
        System.out.print("Pilih metode: ");
        int m = sc.nextInt();

        switch (m) {
            case 1: EkspansiKofaktor.run(); break;
            // case 2: ReduksiBaris.run(); break;
            default: System.out.println("Pilihan tidak valid!");
        }
    }

    // === SUBMENU Invers ===
    private static void menuInvers(Scanner sc) {
        System.out.println("\n--- Matriks Balikan ---");
        System.out.println("1. Metode Augment");
        System.out.println("2. Metode Adjoin");
        System.out.print("Pilih metode: ");
        int m = sc.nextInt();

        switch (m) {
            // case 1: MetodeAugment.run(); break;
            case 2: MetodeAdjoin.run(); break;
            default: System.out.println("Pilihan tidak valid!");
        }
    }

    // === SUBMENU Interpolasi ===
    private static void menuInterpolasi(Scanner sc) {
        System.out.println("\n--- Interpolasi ---");
        System.out.println("1. Interpolasi Polinomial");
        System.out.println("2. Interpolasi Spline Bézier Kubik");
        System.out.print("Pilih metode: ");
        int m = sc.nextInt();

        switch (m) {
            // case 1: Polinomial.run(); break;
            // case 2: SplinaBezierKubik.run(); break;
            default: System.out.println("Pilihan tidak valid!");
        }
    }

    // === SUBMENU Regresi ===
    private static void menuRegresi(Scanner sc) {
        System.out.println("\n--- Regresi Polinomial Berganda ---");
        // RegresiPolinomial.run();
    }
}
