package com.mycompany.tugaspbo;

public class rumus_15240621 {
    // Constants for jacket codes
    public static final int KODE_1 = 1;
    public static final int KODE_2 = 2;
    public static final int KODE_3 = 3;
    public static final int KODE_4 = 4;
    
    // Constants for pricing thresholds
    public static final double DISCOUNT_THRESHOLD = 5; // If quantity > 5, give 2% discount
    public static final double CALENDAR_BONUS_THRESHOLD = 2000000; // If total price > 2 jt
    public static final double PAYUNG_BONUS_THRESHOLD = 1000000; // If total price > 1 jt
    public static final double DISCOUNT_PERCENTAGE = 0.02; // 2% discount
    
    // Method to determine jacket brand based on code
    public String getMerk(int kode) {
        switch (kode) {
            case KODE_1:
                return "kyt";
            case KODE_2:
                return "avl";
            case KODE_3:
                return "hhk";
            case KODE_4:
                return "kkh";
            default:
                return "Unknown";
        }
    }
    
    // Method to determine jacket price based on code
    public double getHarga(int kode) {
        switch (kode) {
            case KODE_1:
                return 500000;
            case KODE_2:
                return 600000;
            case KODE_3:
                return 700000;
            case KODE_4:
                return 800000;
            default:
                return 0; // Invalid code
        }
    }
    
    // Method to calculate subtotal (price * quantity)
    public double calculateSubtotal(double harga, int jumlahBeli) {
        return harga * jumlahBeli;
    }
    
    // Method to calculate discount
    public double calculateDiscount(int jumlahBeli, double subtotal) {
        if (jumlahBeli > DISCOUNT_THRESHOLD) {
            return subtotal * DISCOUNT_PERCENTAGE;
        } else {
            return 0;
        }
    }
    
    // Method to calculate total price after discount
    public double calculateTotalPrice(double subtotal, double discount) {
        return subtotal - discount;
    }
    
    // Method to determine bonus
    public String determineBonus(double totalPrice) {
        if (totalPrice > CALENDAR_BONUS_THRESHOLD) {
            return "Kalender";
        } else if (totalPrice > PAYUNG_BONUS_THRESHOLD) {
            return "Payung";
        } else {
            return "Tidak ada bonus";
        }
    }
}