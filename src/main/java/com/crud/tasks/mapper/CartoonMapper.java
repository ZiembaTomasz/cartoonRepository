package com.crud.tasks.mapper;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.domain.CartoonDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class CartoonMapper {
    SeasonMapper seasonMapper;

    public CartoonDto mapToCartoonDto(final Cartoon cartoon){

        return new CartoonDto(
                cartoon.getId(),
                cartoon.getName(),
                cartoon.getAgeRestriction(),
                cartoon.getRating(),
                seasonMapper.mapToSeasonDto(cartoon.getSeasonList()));

    }
    public List<CartoonDto> mapToCartoonDtoList(final  List<Cartoon>cartoonList){
        List<CartoonDto>cartoonDtoList = new ArrayList<>();

        for (int i = 0; i<cartoonList.size(); i++){
            Cartoon cartoon = cartoonList.get(i);
            cartoonDtoList.add( new CartoonDto(cartoon.getId(),cartoon.getName(),
                    cartoon.getAgeRestriction(),
                    cartoon.getRating(),
                    seasonMapper.mapToSeasonDto(cartoon.getSeasonList())));
        }
        return cartoonDtoList;
    }
    public Cartoon mapToCarton( final CartoonDto cartoonDto) {
        return new Cartoon(cartoonDto.getId(),
                cartoonDto.getName(),
                cartoonDto.getAgeRestriction(),
                cartoonDto.getRating(),
                seasonMapper.mapToSeason(cartoonDto.getSeasonDtos(), cartoonDto));
    }
}
