package com.crud.tasks.calc;

public class Application {
    public static void main(String[]args){
        ForumUser forumUser = new ForumUser("Tomi", "Zimba", "ziembatomasz@gmail.com", "male",
                30, "gorgi", 3, true);
        forumUser.showUser(forumUser);
    }
}
