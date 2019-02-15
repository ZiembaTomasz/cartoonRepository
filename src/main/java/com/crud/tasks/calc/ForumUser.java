package com.crud.tasks.calc;

public class ForumUser extends User{
    private String userName;
    private int postCount;
    private boolean online;

    public ForumUser(String name, String surname, String mail, String sex, int age, String userName, int postCount, boolean online) {
        super(name, surname, mail, sex, age);
        this.userName = userName;
        this.postCount = postCount;
        this.online = online;
    }
    public void addPost(String userName){
        System.out.println(userName + " Adding a post");
    }
    public void commentPost(String userName){
        System.out.println(userName + " Comments a post");
    }
    public void showUser(ForumUser forumUser){
        System.out.println(forumUser);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userName='" + userName + '\'' +
                ", postCount=" + postCount +
                ", online=" + online +
                '}';
    }
}
