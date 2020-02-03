package com.ziembatomasz.crud.cartoons.mapper;

import com.ziembatomasz.crud.cartoons.domain.Episod;
import com.ziembatomasz.crud.cartoons.domain.EpisodDto;
import com.ziembatomasz.crud.cartoons.domain.Season;
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
