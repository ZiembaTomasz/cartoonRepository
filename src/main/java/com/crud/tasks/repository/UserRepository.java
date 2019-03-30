package com.crud.tasks.repository;

import com.crud.tasks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLastnameLike(String name);
}
