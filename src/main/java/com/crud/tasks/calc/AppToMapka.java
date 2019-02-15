package com.crud.tasks.calc;

import java.util.HashMap;
import java.util.Map;

public class AppToMapka {
    public static void main(String[]args){
        Mapka user1 = new Mapka("Michal");
        Mapka user2 = new Mapka("Adam");
        Mapka user3 = new Mapka("Krzys");

        Grades grades1 = new Grades(1, 2, 3);
        Grades grades2 = new Grades(3, 4, 5);
        Grades grades3 = new Grades(2, 6, 6);

        HashMap<Mapka, Grades> averages = new HashMap<>();
        averages.put(user1, grades1);
        averages.put(user2, grades2);
        averages.put(user3, grades3);

        for(Map.Entry<Mapka, Grades> entry: averages.entrySet()){
            System.out.println("Student " + entry.getKey() + " averages is " + entry.getValue().getAverage());
        }



    }
}
