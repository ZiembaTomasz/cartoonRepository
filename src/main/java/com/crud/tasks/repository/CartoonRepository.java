package com.crud.tasks.repository;

import com.crud.tasks.domain.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
    List<Cartoon> findByNameLike(String name);
    @Query
    List <Cartoon> retrieveNewCartoons(@Param("DATE")Date date);
}
