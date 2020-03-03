package com.librarysystem;

import java.util.*;

public class BookHandler {
    List<String> booksChosen = new ArrayList<>();
    Map<Integer, String> booksAvailable = new HashMap<>();
    List<Reservation> reservationList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Scanner choiceSc = new Scanner(System.in);

    BookStorage bookStorage = new BookStorage();
    RegistrationUI regUI = new RegistrationUI();
    DateHandler dh = new DateHandler();

    public BookHandler(Map<Integer, String> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    private boolean checkBookForBeingFree(String book) {
        return booksChosen.contains(book);
    }

    public void maintainExecution() {
        System.out.println("\nIf you want to take new books - enter 1\nElse if you want to return books - enter 2");
        int userChoice = sc.nextInt();
        if (userChoice == 1) {
            takeNewBooks();
        } else if (userChoice == 2) {
            returnBooks();
        } else {
            System.out.println("Please choose between given options.");
        }
    }

    private void soutBooksChosen() {
        for (int i = 0; i < booksChosen.size(); i++) {
            System.out.println((i+1) + ". " + booksChosen.get(i));
        }
    }

    /* TEST */
    private void addReservationsForTest() {
        List<String> testBooks = new ArrayList<>();
        testBooks.add("Ռաֆֆի - Սամվել");
        testBooks.add("Ֆրանց Վերֆել - Մուսա Լեռան 40 Օրը");
        testBooks.add("Շիրվանզադե - Քաոս");
        Reservation rvTest = new Reservation(1, testBooks, dh.currentDate(), dh.expirationDate(), false);
        reservationList.add(rvTest);
    }

    private void takeNewBooks() {
        bookStorage.displayBooks();
        System.out.println("\nEnter numbers of books, that you want to take(enter 0 if finished.)");
        while (true) {
            int userInput = sc.nextInt();
            if (userInput == 0) {
                System.out.println("\nYou have chosen these books: ");
                soutBooksChosen();
                System.out.println("Is everything correct?(y/n)");
                if (choiceSc.nextLine().equals("y")) {
                    System.out.println("\nCreating your order...");
                    String reservationDay = dh.currentDate();
                    String expirationDay  = dh.expirationDate();
                    Reservation rv = new Reservation(regUI.getUid(), booksChosen, reservationDay, expirationDay, false);
                    reservationList.add(rv);
                    System.out.println("Done! Here is your order ID: " + rv.getReservationID() + ".Use it for referring to your order. \nYou can keep those books until " + dh.expirationDate() + ". Please return books in time.");
                    break;
                } else if (choiceSc.nextLine().equals("n")) {
                    System.out.println("Please try again.");
                    break;
                } else {
                    System.out.println("You can only enter y(for yes) or n(for no).");
                }
            } else if (userInput > booksAvailable.size()) {
                System.out.println("There are only " + booksAvailable.size() + " books available. Please choose between them.");
            } else {
                String book = booksAvailable.get(userInput);
                if (!checkBookForBeingFree(book)) {
                    booksChosen.add(book);
                } else {
                    System.out.println("Sorry, your chosen book is unavailable.");
                }
            }
        }
    }


    private Reservation findReservation(int resNum) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getReservationID() == resNum) {
                return reservationList.get(i);
            }
        }
        return null;
    }

    private void soutReservationBooks(Reservation rv) {
        for (int i = 0; i < rv.getBooksOrdered().size(); i++) {
            System.out.println((i+1) + ". " +rv.getBooksOrdered().get(i));
        }
    }

    private void returnBooks() {
        System.out.println("Please enter the number of the order, from which you want to return books.");
        addReservationsForTest();
        int orderNum = sc.nextInt();
        Reservation chosenReservation = findReservation(orderNum);
        if (chosenReservation != null) {
            System.out.println("\nHere are books from your reservation: ");
            soutReservationBooks(chosenReservation);
            System.out.println("\nEnter numbers of books, that you want to return(enter 0 if finished.)");
            while (true) {
                int userInput = sc.nextInt();
                if (chosenReservation.getBooksOrdered().size() != 0) {
                    if (userInput == 0) {
                        System.out.println("Books were returned. Thank you.");
                        break;
                    } else if (userInput > chosenReservation.getBooksOrdered().size()) {
                        System.out.println("There are only " + chosenReservation.getBooksOrdered().size() + " books that you can return. Please choose between them.");
                    } else {
                        String book = chosenReservation.getBooksOrdered().remove(userInput-1);
                        soutReservationBooks(chosenReservation);
                        continue;
                    }
                } else {
                    chosenReservation.setReservationCompleted(true);
                    System.out.println("Book were successfully returned. Thank you.");
                    break;
                }
            }
        } else {
            System.out.println("Error 404. Reservation not found.");
        }


    }
}
