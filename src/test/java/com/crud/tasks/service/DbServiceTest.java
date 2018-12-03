package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {
    @InjectMocks
    private DbService dbService;
    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasks() {
        Task task = new Task(1L, "Washington", "Wall");
        List<Task>taskList = new ArrayList<>();
        taskList.add(task);
        taskList = dbService.getAllTasks();
        assertEquals(taskList, dbService.getAllTasks());
    }
    @Test
    public void saveTask() {
        Task task = new Task(2L, "Fon", "Jon");
        dbService.saveTask(task);
        assertEquals(task.getContent(), "Jon");
    }


}