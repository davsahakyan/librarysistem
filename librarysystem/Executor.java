package com.librarysystem;

public class Executor {
    public static void main(String[] args) {
        BookStorage bs = new BookStorage();

        LoginUI loginUI = new LoginUI(new Administrator("David", "david@gmail.com"));
        int userCase = loginUI.maintainLogin();
        if (userCase == 1) {
            BookHandler bh = new BookHandler(bs.getBookMap());
            RegistrationUI regUI = new RegistrationUI();
            regUI.addUsersForTest();
            regUI.registrateNewUser();
            bh.maintainExecution();
        } else if (userCase == 2) {
            loginUI.getA1().maintainAdmin(bs.getBookList());
        } else if (userCase == 10) {
            loginUI.getA1().maintainAdmin(bs.getBookList());
        } else {
            System.out.println("\nError occurred. Please contact administration.");
        }


    }
}
