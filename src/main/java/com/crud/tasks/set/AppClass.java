package com.crud.tasks.set;

import java.util.HashSet;

public class AppClass {
    public static void main(String[]args){
        Students students = new Students("George", "Rootkinson", 1998);
        Students students1 = new Students("Hail", "Swinzermman", 2001);
        Students students2 = new Students("Will", "Smith", 2005);

        HashSet<Students>newSet = new HashSet<>();
        newSet.add(students);
        newSet.add(students1);
        newSet.add(students2);

        for(Students newBooks:newSet){
            if(newBooks.year > 2000){
                System.out.println(newBooks);
            }
        }
    }
}
