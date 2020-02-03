package com.ziembatomasz.crud.cartoons.repository;

import com.ziembatomasz.crud.cartoons.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
