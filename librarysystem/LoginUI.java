package com.librarysystem;

import java.util.Scanner;

public class LoginUI {
    private String password = "password";
    private Administrator a1;
    private BookStorage bs = new BookStorage();
    private Scanner sc = new Scanner(System.in);

    public LoginUI(Administrator a1) {
        this.a1 = a1;
    }

    public Administrator getA1() {
        return a1;
    }

    public String getPassword() {
        return password;
    }

    private boolean checkPasswordValidation(String userPassword) {
        return userPassword.equals(this.password);
    }

    public int maintainLogin() {
        System.out.println("Welcome to library automation system (c)2019.\nLogin as: \nuser(0)\nadmin(1)");
        int loginCase = sc.nextInt();
        if (loginCase == 0) {
            System.out.println("Access Granted!");
            return 1;
        } else if (loginCase == 1) {
            Scanner passwordSc = new Scanner(System.in);
            System.out.print("Enter password: ");
            String userPassword = passwordSc.nextLine();
            if (checkPasswordValidation(userPassword)) {
                System.out.println("\nYou logged in as " + a1.getName());
                return 2;
            } else {
                System.out.println("\nAccess Denied! Wrong Password.");
                return 3;
            }
        } else if (loginCase == 10) {
            return 10;
        } else {
            return 0;
        }
    }
}
