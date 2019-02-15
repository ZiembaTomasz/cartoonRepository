package com.crud.tasks.calc;

import java.util.Random;

public class Sum {
    public static void main(String[]args){
        int sumA = 1000;
        int sumB = 0;
        int sum = sumA + sumB;
        Random genA = new Random();
        Random genB = new Random();
        boolean condition = false;
        int counter = 0;
        while(!condition){
            counter++;
            int a = genA.nextInt(9);
            int b = genB.nextInt(49);
            sumA = a + sumA;
            sumB = b + sumB;
            System.out.println("Attempts " + counter);
            if(sumB > sumA){
                condition = true;
            }
        }
        System.out.println("Finitttooooo");


    }
}
