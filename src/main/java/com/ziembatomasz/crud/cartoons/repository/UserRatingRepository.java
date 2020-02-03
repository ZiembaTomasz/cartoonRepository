package com.ziembatomasz.crud.cartoons.repository;

import com.ziembatomasz.crud.cartoons.domain.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
    List<UserRating> findUserRatingByCartoonId(Long cartoonID);

}
