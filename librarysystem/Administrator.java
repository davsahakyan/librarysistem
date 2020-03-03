package com.librarysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator {
    private String name;
    private String email;
    private int adminID;

    private int adminIDCounter = 0;

    private BookStorage bs = new BookStorage();

    public Administrator(String name, String email) {
        this.name = name;
        this.email = email;
        this.adminIDCounter += 1;
        this.adminID = this.adminIDCounter;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getName() {
        return name;
    }

    private boolean doesBookAlreadyExist(String book, List<String> bookLs) {
        for (String s : bookLs) {
            if (book.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void maintainAdmin(List<String> books) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose action\n1. Add new books\n2. Remove books");
        int admChoice = sc.nextInt();
        if (admChoice == 1) {
            System.out.println("Enter books names that you want to add(if finished, enter  0)");
            List<String> newBookList = new ArrayList<>();
            Scanner sca = new Scanner(System.in);
            while (true) {
                String book = sca.nextLine();
                System.out.println(book);
                if (book.equals("")) {
                    System.out.println("You can't add empty book");
                } else if (doesBookAlreadyExist(book, books)) {
                    System.out.println("That book already exists");
                } else if ("0".equals(book)) {
                    System.out.println("\nAdding new books...");
                    bs.addBooks(newBookList);
                    System.out.print("\n");
                    bs.displayBooks();
                    break;
                } else {
                    newBookList.add(book);
                }


            }
        } else if (admChoice == 2) {
            System.out.print("\n");
            bs.displayBooks();
            System.out.println("Enter book numbers, that you want to remove(if finished, enter 0)");
            Scanner sca = new Scanner(System.in);
            while (true) {
                int bookNum = sca.nextInt();
                if (books.size() != 0) {
                    if (bookNum == 0) {
                        System.out.println("Books were removed.\n");
                        if (books.size() != 0) {
                            bs.displayBooksNames();
                        }
                        break;
                    } else if (bookNum > books.size()) {
                        System.out.println("There are only " + books.size() + " books that you can remove. Please choose between them.");
                    } else {
                        bs.removeBooks(bookNum);
                    }
                } else {
                    System.out.println("No more books are left to return.");
                    break;
                }
            }

        } else {
            System.out.println("There are only two options, please choose between them.");
        }
    }
}
