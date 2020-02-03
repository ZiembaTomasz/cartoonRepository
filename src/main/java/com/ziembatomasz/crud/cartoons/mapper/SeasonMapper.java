package com.ziembatomasz.crud.cartoons.mapper;

import com.ziembatomasz.crud.cartoons.domain.CartoonDto;
import com.ziembatomasz.crud.cartoons.domain.Season;
import com.ziembatomasz.crud.cartoons.domain.SeasonDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeasonMapper {
    public List<SeasonDto> mapToSeasonDto(List<Season>seasonList){
        return seasonList.stream()
                .map(this::mapToSeasonDto)
                .collect(Collectors.toList());

    }
    public Season mapToSeason(SeasonDto seasonDto, CartoonDto cartoonDto){
        return new Season(seasonDto.getId(), cartoonDto.getId(), seasonDto.getName(), seasonDto.getNumberOfSeasons());
    }

    public SeasonDto mapToSeasonDto(Season season){
        return new SeasonDto(season.getId(), season.getName(), season.getNumberOfSeasons());
    }
    public List<Season> mapToSeason(List<SeasonDto>seasonDtoList, CartoonDto cartoonDto){
        return seasonDtoList.stream()
                .map(t -> mapToSeason(t, cartoonDto))
                .collect(Collectors.toList());
    }
}
