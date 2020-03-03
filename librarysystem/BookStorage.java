package com.librarysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStorage {
    private Map<Integer, String> bookList = new HashMap<>();

    public BookStorage() {
        this.archiveBooks();
    }

    public void archiveBooks() {
        this.bookList.put(1, "Ռաֆֆի - Սամվել");
        this.bookList.put(2, "Ֆրանց Վերֆել - Մուսա Լեռան 40 Օրը");
        this.bookList.put(3, "Շիրվանզադե - Քաոս");
        this.bookList.put(4, "Ստեփան Զորյան - Մի կյանքի պատմություն");
        this.bookList.put(5, "Պարույր Սեվակ - Անլռելի Զանգակատուն");
    }

    public void addBooks(List<String> newBooks) {
        int lastKey = bookList.size();
        for (String s : newBooks) {
            lastKey+=1;
            bookList.put(lastKey, s);
        }
    }

    public void displayBooks() {
        System.out.println("Available books: ");
        for (int i = 1; i <= getLen(); i++) {
            System.out.println(i + ". " + this.bookList.get(i));
        }
    }

    public void displayBooksNames() {
        System.out.println("Available books: ");
        for (int i : bookList.keySet()) {
            System.out.println(bookList.get(i));
        }
    }

    public void removeBooks(int bookKey) {
        bookList.remove(bookKey);
    }


    private int getLen() {
        return this.bookList.size();
    }

    public Map<Integer, String> getBookMap() {
        return this.bookList;
    }

    public List<String> getBookList() {
        List<String> bookConv = new ArrayList<>(this.bookList.values());
        return bookConv;
    }


}
