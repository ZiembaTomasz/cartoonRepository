package com.ziembatomasz.crud.cartoons.repository;

import com.ziembatomasz.crud.cartoons.domain.Episod;
import com.ziembatomasz.crud.cartoons.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodRepository extends JpaRepository<Episod, Long> {
    public List<Episod> findBySeason(Season season);
}
