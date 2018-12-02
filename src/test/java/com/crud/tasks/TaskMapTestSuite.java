package com.crud.tasks;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapTestSuite {
    @InjectMocks
    TaskMapper taskMapper;
    @Mock
    private Task task;
    @Mock
    private TaskDto taskDto;

    @Test
    public void mapToTaskTest(){
        //Given
        Task task = new Task(35L, "George", "Blind");
        TaskDto taskDto = new TaskDto(20L, "Andy", "The Super");
        //When
        task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }
    @Test
    public void mapToTaskDto(){
        //Given
        Task task = new Task(30L, "Will", "Bald");
        TaskDto taskDto = new TaskDto(25L, "George", "The Xin");
        //When
        taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }
    @Test
    public void mapToTaskDtoList(){
        TaskDto taskDto = new TaskDto(5L, "Quin", "Falcon");
        Task task = new Task(30L, "Will", "Bald");
        List<TaskDto>taskDtos = new ArrayList<>();
        List<Task>taskList = new ArrayList<>();
        taskList.add(task);
        taskDtos.add(taskDto);
        taskDtos = taskMapper.mapToTaskDtoList(taskList);
        assertEquals(taskDtos.size(), taskList.size());

    }
}
