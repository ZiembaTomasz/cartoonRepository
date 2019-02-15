package com.crud.tasks.calc;

import java.sql.SQLOutput;

public class User {
    private String name;
    private String surname;
    private String mail;
    private String sex;
    private int age;

    public User(String name, String surname, String mail, String sex, int age) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.sex = sex;
        this.age = age;
    }
    public void logIn(){
        System.out.println("User log in");
    }
    public void removeAccount(String mail){
        System.out.println("Account " + getMail() + " is removed");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
