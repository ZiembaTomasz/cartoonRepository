package com.crud.tasks.repository;

import com.crud.tasks.domain.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
    List<Cartoon> findByNameLike(String name);
}
