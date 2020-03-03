package com.librarysystem;


import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationUI {
    private ArrayList<User> users = new ArrayList<>();
    private int uid = 0;
    private int uc = 0; // Test users count;
    private int testUid = 0;
    public int getUid() {
        return uid;
    }

    public void addUsersForTest() {
        addUserForTest("Hayk", "Gagikyan", 32, "sample");
        addUserForTest("Galust", "Sargsyan", 45, "sample");
        addUserForTest("Vardanush", "Simonyan", 23, "sample");
    }

    private void addUserForTest(String name, String surname, int age, String email) {
        this.users.add(uc, new User());
        User currentUser = this.users.get(uc);
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setAge(age);
        currentUser.setEmail(email);
        testUid -= 1;
        currentUser.setUserID(testUid);
    }

    public void registrateNewUser() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner userSc = new Scanner(System.in);
        int i = users.size();
        this.users.add(i, new User());
        System.out.println("Dear user, let's create a library card for you");
        System.out.print("Your name: ");
        this.users.get(i).setName(sc3.nextLine());
        System.out.print("Your surname: ");
        this.users.get(i).setSurname(sc2.nextLine());
        System.out.print("Your age: ");
        this.users.get(i).setAge(sc.nextInt());
        System.out.print("Your email address: ");
        this.users.get(i).setEmail(sc1.nextLine());
        this.uid += 1;
        this.users.get(i).setUserID(uid);
        System.out.println("Done with registration! Your card is not restorable, so keep it safe.\n");
        System.out.println("Here is your card: ");
        this.users.get(i).soutCardInfo();
        System.out.println("Note! You have two weeks to return the books. Please return it in time.");
    }
}