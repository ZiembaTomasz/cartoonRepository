package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.Episod;
import com.ziembatomasz.crud.cartoons.domain.EpisodDto;
import com.ziembatomasz.crud.cartoons.domain.Season;
import com.ziembatomasz.crud.cartoons.mapper.EpisodMapper;
import com.ziembatomasz.crud.cartoons.repository.EpisodRepository;
import com.ziembatomasz.crud.cartoons.repository.SeasonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpisodService {
    private EpisodRepository episodRepository;
    private EpisodMapper episodMapper;
    private SeasonRepository seasonRepository;


    public EpisodDto saveEpisod(EpisodDto episodDto, Long seasondId){
        Episod episod = episodMapper.mapToEpisod(episodDto,seasonRepository.getOne(seasondId));
        episodRepository.save(episod);
        return episodMapper.mapToEpisodDto(episodRepository.save(episod));
    }
    public List<EpisodDto>getEpisods(Long seasonId){
        Season season = seasonRepository.getOne(seasonId);
        return episodMapper.mapToEpisodDto(episodRepository.findBySeason(season));
    }
    public void deleteEpisode(Long seasonId){
        episodRepository.delete(seasonId);
    }
    public EpisodDto getEpisod(Long episodId){
        return episodMapper.mapToEpisodDto(episodRepository.getOne(episodId));
    }
}
