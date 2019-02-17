package com.crud.tasks.service;

import com.crud.tasks.domain.Episod;
import com.crud.tasks.domain.EpisodDto;
import com.crud.tasks.domain.Season;
import com.crud.tasks.domain.SeasonDto;
import com.crud.tasks.mapper.EpisodMapper;
import com.crud.tasks.mapper.SeasonMapper;
import com.crud.tasks.repository.EpisodRepository;
import com.crud.tasks.repository.SeasonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpisodService {
    private EpisodRepository episodRepository;
    private EpisodMapper episodMapper;
    private SeasonRepository seasonRepository;
    private SeasonMapper seasonMapper;

    public EpisodDto saveEpisod(EpisodDto episodDto, Long seasondId){
        Episod episod = episodMapper.mapToEpisod(episodDto,seasonRepository.getOne(seasondId));
        episodRepository.save(episod);
        return episodMapper.mapToEpisodDto(episodRepository.save(episod));
    }
    public List<EpisodDto>getEpisods(Long seasonId){
        Season season = seasonRepository.getOne(seasonId);
        return episodMapper.mapToEpisodDto(episodRepository.findBySeason(season));
    }
}
