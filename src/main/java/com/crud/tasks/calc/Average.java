package com.crud.tasks.calc;

public class Average {
    public static void main (String[] args) throws java.lang.Exception
    {
        int sum = 0;
        int quantity = 0;
        for(int i=0; i<3; i++){
            for(int k=0; k<2; k++){
                sum = sum + i + k;
                quantity++;
            }
        }
        System.out.println("Sum of elements: " + sum);
        System.out.println("Quantity of elements: " + quantity);
        System.out.println("Average value: " + sum/quantity);
    }
}
