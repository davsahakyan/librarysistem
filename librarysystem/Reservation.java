package com.librarysystem;

import java.util.List;

public class Reservation {
    private List<String> booksOrdered;

    private int userID;
    private int reservationID = 0;

    private String reservationDate;
    private String expirationDate;

    private boolean reservationCompleted;

    public Reservation(int userID, List<String> booksOrdered, String reservationDate, String expirationDate, boolean reservationCompleted) {
        this.userID = userID;
        this.booksOrdered = booksOrdered;
        this.reservationDate = reservationDate;
        this.expirationDate = expirationDate;
        this.reservationCompleted = reservationCompleted;
        this.reservationID += 1;
    }

    public void setReservationCompleted(boolean reservationCompleted) {
        this.reservationCompleted = reservationCompleted;
    }

    public int getReservationID() {
        return reservationID;
    }

    public List<String> getBooksOrdered() {
        return booksOrdered;
    }
}
