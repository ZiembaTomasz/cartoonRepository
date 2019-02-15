package com.crud.tasks.calc;

import java.util.ArrayDeque;

public class QueuesAndLoops {
    public static void main (String[] args) throws java.lang.Exception
    {
        //the first task's list
        ArrayDeque<String> taskQueue1 = new ArrayDeque<String>();
        for(int n=0; n < 5; n++){
            taskQueue1.offer("The first task number " + (n+1));
        }

        //the second task's list
        ArrayDeque<String> taskQueue2 = new ArrayDeque<String>();
        for(int n=0; n < 5; n++){
            taskQueue2.offer("The second task number " + (n+1));
        }

        TaskManager taskExecutor = new TaskManager();
        taskExecutor.executeTasks(taskQueue1);
        taskExecutor.executeTasks(taskQueue2);
    }

}
