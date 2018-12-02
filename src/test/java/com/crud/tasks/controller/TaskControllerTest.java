package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {
    @InjectMocks
    TaskController taskController;
    @Mock
    DbService dbService;
    @Mock
    TaskMapper taskMapper;


    @Test
    public void testGetTask() throws TaskNotFoundException{
        //Given
        Long taskId = 5L;
        Task task = new Task(10L, "Jesus", "33");
        TaskDto taskDto = new TaskDto();
        Optional<Task>taskOptional = Optional.of(task);
        when(dbService.getTask(taskId)).thenReturn(taskOptional);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        TaskDto result = taskController.getTask(taskId);
        assertEquals(taskDto, result);
    }
    @Test
    public void testDeleteTask(){
        //Given
        Long taskId = 5L;

        //When
        taskController.deleteTask(taskId);

        //Then
        verify(dbService).deleteId(taskId);
    }
    @Test
    public void testGetTasks(){
        List<TaskDto>taskDtos = new ArrayList<>();

        taskDtos = taskController.getTasks();

        assertEquals(0, taskDtos.size());
    }
    @Test
    public void updateTest(){
        TaskDto taskDto = new TaskDto(2L, "Fok", "Teat");
        Task task = new Task(2L, "Snow", "Gorg");
        when(taskMapper.mapToTaskDto(dbService.saveTask(taskMapper.mapToTask(taskDto)))).thenReturn(taskDto);
        TaskDto result1 = taskController.updateTask(taskDto);
        assertEquals(taskDto, result1);
    }
    @Test
    public void createTest(){
        List<TaskDto>taskDtos = new ArrayList<>();
        TaskDto taskDto = new TaskDto(2L, "Fok", "Teat");
        taskDtos.add(taskDto);
        Task task = new Task(2L, "Snow", "Gorg");
        when(dbService.saveTask(taskMapper.mapToTask(taskDto))).thenReturn(task);
        taskController.createTask(taskDto);
        assertEquals(1, taskDtos.size());
    }
}