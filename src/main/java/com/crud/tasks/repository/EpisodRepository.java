package com.crud.tasks.repository;

import com.crud.tasks.domain.Episod;
import com.crud.tasks.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodRepository extends JpaRepository<Episod, Long> {
    public List<Episod> findBySeason(Season season);
}
