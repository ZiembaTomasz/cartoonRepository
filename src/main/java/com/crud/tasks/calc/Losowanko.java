package com.crud.tasks.calc;

import java.util.Random;

public class Losowanko {
    public static void main(String[]args){

        for(int n = 10; n < 4; n++ ){

            Random random = new Random();
            int s = random.nextInt(33);
            System.out.println(n);
        }

    }
}
