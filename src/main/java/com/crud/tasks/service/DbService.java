package com.crud.tasks.service;


import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public Task saveTask (final Task task){
        return repository.save(task);
    }
    public Optional<Task> getTask(final Long id){
        return  repository.findById(id);
    }
    public void deleteId(final Long id){
        repository.delete(id);
    }
}
