package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.repository.CartoonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class CartoonMapper {
    SeasonMapper seasonMapper;
    CartoonRepository cartoonRepository;

    public CartoonDto mapToCartoonDto(final Cartoon cartoon) {
        return new CartoonDto(
                cartoon.getId(),
                cartoon.getName(),
                cartoon.getAgeRestriction(),
                cartoon.ratingAverage(),
                cartoon.getDate(),
                seasonMapper.mapToSeasonDto(cartoon.getSeasons()));

    }

    public List<CartoonDto> mapToCartoonDtoList(final List<Cartoon> cartoonList) {
        List<CartoonDto> cartoonDtoList = new ArrayList<>();

        for (int i = 0; i < cartoonList.size(); i++) {
            Cartoon cartoon = cartoonList.get(i);
            cartoonDtoList.add(new CartoonDto(cartoon.getId(), cartoon.getName(),
                    cartoon.getAgeRestriction(),
                    cartoon.ratingAverage(),
                    cartoon.getDate(),
                    seasonMapper.mapToSeasonDto(cartoon.getSeasons())));
        }
        return cartoonDtoList;
    }

    public Cartoon mapToCarton(final CartoonDto cartoonDto) {
        Cartoon cartoon = cartoonRepository.findOne(cartoonDto.getId());
        List<UserRating> userRatings = new ArrayList<>();
        List<Season>seasons = new ArrayList<>();
        if(cartoonDto.getSeasonDtos() != null){
            seasons = seasonMapper.mapToSeason(cartoonDto.getSeasonDtos(), cartoonDto);

        }
        if(cartoon != null){
            userRatings = cartoonRepository.findOne(cartoonDto.getId()).getUserRatings();
        }
        return new Cartoon(cartoonDto.getId(),
                cartoonDto.getName(),
                cartoonDto.getAgeRestriction(),
                cartoonDto.getDate(),
                seasons,
                userRatings
                );
    }
}
