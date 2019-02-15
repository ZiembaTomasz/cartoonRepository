package com.crud.tasks.repository;

import com.crud.tasks.domain.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartoonRepository extends JpaRepository<Cartoon, Long> {


}
