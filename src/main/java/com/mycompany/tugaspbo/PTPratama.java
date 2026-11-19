package com.mycompany.tugaspbo;

import java.util.Scanner;

public class PTPratama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data barang
        String[] kodeBarang = {"P001", "V001", "M001"};
        String[] namaBarang = {"Printer", "VGA Card", "Motherboard"};
        int[] hargaBarang = {700000, 75000, 950000};

        // Input data petugas
        System.out.println("PT. PERMATA \"PRATAMA\"");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("Masukan Nama Petugas    : ");
        String namaPetugas = input.nextLine();
        System.out.print("Tanggal                 : ");
        String tanggal = input.nextLine();
        System.out.print("Jumlah Data yang akan dimasukan : ");
        int jumlahData = input.nextInt();
        input.nextLine(); // Clear buffer
        System.out.println("----------------------------------------------");

        // Deklarasi array
        String[] kode = new String[jumlahData];
        int[] jumlah = new int[jumlahData];
        String[] barang = new String[jumlahData];
        int[] harga = new int[jumlahData];
        int[] total = new int[jumlahData];
        int totalPendapatan = 0;

        // Input data transaksi
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Data Ke-" + (i + 1));
            System.out.print("Kode Barang: ");
            kode[i] = input.nextLine();
            System.out.print("Jumlah Barang: ");
            jumlah[i] = input.nextInt();
            input.nextLine(); // Clear buffer

            // Mencari barang berdasarkan kode
            for (int j = 0; j < kodeBarang.length; j++) {
                if (kode[i].equalsIgnoreCase(kodeBarang[j])) {
                    barang[i] = namaBarang[j];
                    harga[i] = hargaBarang[j];
                    break;
                }
            }

            total[i] = harga[i] * jumlah[i];
            totalPendapatan += total[i];
            System.out.println("----------------------------------------------");
        }

        // Output hasil
        System.out.println("\nPT. PERMATA \"PRATAMA\"");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Nama Petugas           : " + namaPetugas);
        System.out.println("Tanggal                : " + tanggal);
        System.out.println("Jumlah Data yang dimasukan : " + jumlahData);
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s %-12s %-13s %-13s %-13s %-13s\n", "Data Ke-", "Kode Barang", "Nama Barang", "Harga Barang", "Jumlah Barang", "Total Harga");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-10d %-12s %-13s Rp. %-10d %-13d Rp. %-10d\n", i + 1, kode[i], barang[i], harga[i], jumlah[i], total[i]);
        }

        System.out.println("----------------------------------------------");
        System.out.println("Total Pendapatan Pada tanggal " + tanggal + " adalah sebesar Rp. " + totalPendapatan);
    }
}