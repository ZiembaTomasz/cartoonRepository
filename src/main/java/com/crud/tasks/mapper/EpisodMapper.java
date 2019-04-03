package com.crud.tasks.mapper;

import com.crud.tasks.domain.Episod;
import com.crud.tasks.domain.EpisodDto;
import com.crud.tasks.domain.Season;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EpisodMapper {
    public Episod mapToEpisod(EpisodDto episodDto, Season season) {
        return new Episod(episodDto.getId(), episodDto.getName(), season);
    }

    public EpisodDto mapToEpisodDto(Episod episod) {
        return new EpisodDto(episod.getId(), episod.getName());
    }

    public List<EpisodDto> mapToEpisodDto(List<Episod> episods) {
        return episods.stream()
                .map(t -> mapToEpisodDto(t))
                .collect(Collectors.toList());
    }

}
