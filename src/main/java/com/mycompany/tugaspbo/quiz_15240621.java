package com.mycompany.tugaspbo;

import java.util.Scanner;

public class quiz_15240621 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        rumus_15240621 rumus = new rumus_15240621();
        
        System.out.println("=================================================");
        System.out.println("                 DISTRO KERENZ                   ");
        System.out.println("=================================================");
        System.out.println("KODE\tMERK\t\tHARGA");
        System.out.println("1\tkyt\t\tRp 500.000");
        System.out.println("2\tavl\t\tRp 600.000");
        System.out.println("3\thhk\t\tRp 700.000");
        System.out.println("4\tkkh\t\tRp 800.000");
        System.out.println("=================================================");
        
        // Input section
        System.out.print("Masukkan Jumlah Data = ");
        int jumlahData = input.nextInt();
        input.nextLine(); // Consume the remaining newline
        
        // Arrays to store data
        int[] kodeJaket = new int[jumlahData];
        int[] jumlahBeli = new int[jumlahData];
        String[] merk = new String[jumlahData];
        double[] harga = new double[jumlahData];
        double[] subtotal = new double[jumlahData];
        double[] potongan = new double[jumlahData];
        double[] jumlahHarga = new double[jumlahData];
        double totalHarga = 0;
        
        // Input data for each item
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("\nData ke-" + (i+1));
            
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Kode Jaket (1-4): ");
                    kodeJaket[i] = input.nextInt();
                    if (kodeJaket[i] >= 1 && kodeJaket[i] <= 4) {
                        validInput = true;
                    } else {
                        System.out.println("Error: Kode jaket harus antara 1-4. Silahkan coba lagi.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Masukkan angka 1-4 saja. Silahkan coba lagi.");
                    input.nextLine(); // Clear the invalid input
                }
            }
            
            System.out.print("Jumlah Beli : ");
            jumlahBeli[i] = input.nextInt();
            input.nextLine(); // Consume the remaining newline
            
            // Process data
            merk[i] = rumus.getMerk(kodeJaket[i]);
            harga[i] = rumus.getHarga(kodeJaket[i]);
            subtotal[i] = rumus.calculateSubtotal(harga[i], jumlahBeli[i]);
            potongan[i] = rumus.calculateDiscount(jumlahBeli[i], subtotal[i]);
            jumlahHarga[i] = rumus.calculateTotalPrice(subtotal[i], potongan[i]);
            
            totalHarga += jumlahHarga[i];
        }
        
        // Determine bonus
        String bonus = rumus.determineBonus(totalHarga);
        
        // Display results
        System.out.println("\n=======================================================================================");
        System.out.println("                 DISTRO KERENZ                   ");
        System.out.println("=========================================================================================");
        System.out.println("NO\tMERK\tHARGA\t\tJML BELI\tPOTONGAN\tJML HARGA");
        System.out.println("=========================================================================================");
        
        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%d\t%s\tRp %,.0f\t%d\t\tRp %,.0f\tRp %,.0f\n", 
                (i+1), merk[i], harga[i], jumlahBeli[i], potongan[i], jumlahHarga[i]);
        }
        
        System.out.println("=========================================================================================");
        System.out.printf("TOTAL HARGA\t\t\t\t\t= Rp %,.0f\n", totalHarga);
        System.out.printf("BONUS\t\t\t\t\t\t= %s\n", bonus);
        System.out.println("=========================================================================================");
        System.out.println("*TERIMA KASIH");
        
        input.close();
    }
}