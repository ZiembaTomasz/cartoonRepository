package com.crud.tasks.mapper;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.domain.CartoonDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartoonMapper {
    public CartoonDto mapToCartoonDto(final Cartoon cartoon){
        return new CartoonDto(
                cartoon.getId(),
                cartoon.getName(),
                cartoon.getAgeRestriction(),
                cartoon.getRating());
    }
    public List<CartoonDto> mapToCartoonDtoList(final  List<Cartoon>cartoonList){
        List<CartoonDto>cartoonDtoList = new ArrayList<>();

        for (int i = 0; i<cartoonList.size(); i++){
            Cartoon cartoon = cartoonList.get(i);
            cartoonDtoList.add( new CartoonDto(cartoon.getId(),cartoon.getName(),
                    cartoon.getAgeRestriction(),
                    cartoon.getRating()));
        }
        return cartoonDtoList;
    }
    public Cartoon mapToCarton( final CartoonDto cartoonDto){
        return new Cartoon(cartoonDto.getId(),
                cartoonDto.getName(),
                cartoonDto.getAgeRestriction(),
                cartoonDto.getRating());
    }
}
