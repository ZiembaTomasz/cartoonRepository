package com.crud.tasks.com.crud.tasks.repository;

import com.crud.tasks.com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();
}
