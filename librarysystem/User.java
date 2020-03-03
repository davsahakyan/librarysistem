package com.librarysystem;

public class User {
    private String name;
    private String surname;
    private int age;
    private String email;
    private int userID;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void soutCardInfo() {
        System.out.println("Card owner name: " + getName());
        System.out.println("Card owner surname: " + getSurname());
        System.out.println("Card owner age: " + getAge());
        System.out.println("Card owner phone number: " + getEmail());
        System.out.println("Card owner ID: " + getUserID() + "\n");
    }
}