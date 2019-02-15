package com.crud.tasks.calc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class APrinter {

    ArrayList<String> even;
    ArrayList<String> odd;

    public APrinter()
    {
        even = new ArrayList<String>();
        odd = new ArrayList<String>();

    }


    public void executeTasks (ArrayDeque<String>theLists)
    {

        for(String a : theLists)
        {
            if (a.length() % 2 == 0)
            {
                this.even.add(a);
            }
            else
            {
                this.odd.add(a);

            }
        }
    }

    public static void main(String[]args)
    {

        Random theGenerator1 = new Random();

        ArrayDeque<String>theList = new ArrayDeque<String>();
        for(int n = 0; n<50; n++)

        {
            int b = theGenerator1.nextInt(50) + 1;
            String c = "";
            for(int i = 0; i<b; i++)
            {
                c += 'a';
            }

            theList.offer(c);
        }
        System.out.print(theList);

        APrinter tester = new APrinter();
        tester.executeTasks(theList);

        System.out.println();
    }
}
