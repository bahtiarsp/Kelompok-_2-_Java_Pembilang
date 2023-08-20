
package com.mycompany.pembilangangka;

import java.util.Scanner;

public class PembilangAngka {
    // Daftar kata untuk mewakili angka 0 hingga 9
    private static final String[] kataAngka = {"nol", "se", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan"};

    // Daftar kata untuk mewakili angka 10 hingga 90 dengan interval 10
    private static final String[] kataPuluhan = {"sepuluh", "dua puluh", "tiga puluh", "empat puluh", "lima puluh", "enam puluh", "tujuh puluh", "delapan puluh", "sembilan puluh"};

    // Daftar kata khusus untuk angka 11 hingga 19
    private static final String[] kataKhusus = {"sebelas", "dua belas", "tiga belas", "empat belas", "lima belas", "enam belas", "tujuh belas", "delapan belas", "sembilan belas"};

    public static String ubahAngkaKeKata(long angka) {
        if (angka == 0) {
            return "nol";
        } else if (angka < 10) {
            return kataAngka[(int) angka];
        } else if (angka >= 10 && angka < 20) {
            return kataKhusus[(int) angka % 10 - 1];
        } else if (angka >= 20 && angka < 100) {
            int puluhan = (int) angka / 10;
            int satuan = (int) angka % 10;
            if (satuan == 0) {
                return kataPuluhan[puluhan - 1];
            } else {
                return kataPuluhan[puluhan - 1] + " " + kataAngka[satuan];
            }
        } else if (angka >= 100 && angka < 1000) {
            int ratusan = (int) angka / 100;
            int sisanya = (int) angka % 100;
            if (sisanya == 0) {
                return kataAngka[ratusan] + " ratus";
            } else {
                return kataAngka[ratusan] + " ratus " + ubahAngkaKeKata(sisanya);
            }
        } else if (angka >= 1000 && angka < 1000000) {
            int ribuan = (int) angka / 1000;
            int sisanya = (int) angka % 1000;
            if (sisanya == 0) {
                return ubahAngkaKeKata(ribuan) + " ribu";
            } else {
                return ubahAngkaKeKata(ribuan) + " ribu " + ubahAngkaKeKata(sisanya);
            }
        } else if (angka >= 1000000 && angka < 1000000000) {
            int jutaan = (int) angka / 1000000;
            int sisanya = (int) angka % 1000000;
            if (sisanya == 0) {
                return ubahAngkaKeKata(jutaan) + " juta";
            } else {
                return ubahAngkaKeKata(jutaan) + " juta " + ubahAngkaKeKata(sisanya);
            }
        } else {
            return "Angka diluar jangkauan";
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan Nominal: ");
        
        try {
            long angka = keyboard.nextLong();
            String terjemahan = ubahAngkaKeKata(angka);
            System.out.println(terjemahan + " rupiah");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input tidak valid");
        }
    }
}
