package com.ziembatomasz.crud.cartoons.repository;

import com.ziembatomasz.crud.cartoons.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLastnameLike(String name);
}
