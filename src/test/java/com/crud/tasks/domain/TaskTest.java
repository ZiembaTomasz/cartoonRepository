package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskTest {
    @Test
    public void getterTest(){
        Task task = new Task(2L, "Jon", "Title");

        String title = task.getTitle();
        String content = task.getContent();
        Long me = task.getId();

        assertEquals("Jon", title);
        assertEquals(2L, me, 0.1);
        assertEquals("Title", content);
    }

}
