package com.librarysystem;

public class Tester {
    public static void main(String[] args) {
        DateHandler dh = new DateHandler();
        System.out.println(dh.currentDate());
        System.out.println(dh.expirationDate());
    }
}
