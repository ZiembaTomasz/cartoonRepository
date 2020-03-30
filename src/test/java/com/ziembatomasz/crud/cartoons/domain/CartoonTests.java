package com.ziembatomasz.crud.cartoons.domain;

import com.ziembatomasz.crud.cartoons.mapper.CartoonMapper;
import com.ziembatomasz.crud.cartoons.mapper.SeasonMapper;
import com.ziembatomasz.crud.cartoons.repository.CartoonRepository;
import com.ziembatomasz.crud.cartoons.service.CartoonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartoonTests {

    CartoonService cartoonService;
    @Mock
    SeasonMapper seasonMapper;
    @Mock
    CartoonRepository cartoonRepository;

    CartoonMapper cartoonMapper;

    @Before
    public void createCartoonServiceObject() {
        cartoonMapper = new CartoonMapper(seasonMapper, cartoonRepository);
        cartoonService = new CartoonService(cartoonRepository, cartoonMapper);
    }


    @Test
    public void shouldReturnAverageTest() {
        Cartoon cartoon = new Cartoon();
        List<UserRating> userRatings = new ArrayList<>();
        userRatings.add(new UserRating(2L, 10, null, 2L));
        userRatings.add(new UserRating(2L, 0, null, 2L));
        cartoon.setUserRatings(userRatings);
        //When
        double srednia = cartoon.ratingAverage();
        //Then
        assertEquals(5.0, srednia, 0.1);
    }

    @Test
    public void shouldGetAllCartoons() {
        //Given
        List<Season> seasonList = new ArrayList<>();
        List<UserRating> userRatingList = new ArrayList<>();
        Date date = new GregorianCalendar(1988, 06, 15).getGregorianChange();
        Cartoon cartoon = new Cartoon(1L, "Tom & Jerry", 10, date, seasonList, userRatingList);
        Cartoon cartoon1 = new Cartoon(2L, "Ed, Edd & Eddy", 9, date, seasonList, userRatingList);
        List<Cartoon> cartoonList = new ArrayList<>();
        cartoonList.add(cartoon);
        cartoonList.add(cartoon1);
        when(cartoonRepository.findAll()).thenReturn(cartoonList);
        //When
        List<CartoonDto> myCartoons = cartoonService.getAllCartoons();
        //Then
        assertEquals(2, myCartoons.size());
    }

    @Test
    public void shouldGetCartoon(){
        List<Season> seasonList = new ArrayList<>();
        //Given
        List<UserRating> userRatingList = new ArrayList<>();
        Date date = new GregorianCalendar(1988, 06, 15).getGregorianChange();
        Cartoon cartoon = new Cartoon(1L, "Tom & Jerry", 10, date, seasonList, userRatingList);
        when(cartoonRepository.getOne(1L)).thenReturn(cartoon);
        //When
        Cartoon myCartoon = cartoonMapper.mapToCarton(cartoonService.getCartoon(1L));
        //Then
        assertEquals(10, myCartoon.getAgeRestriction());
    }

    @Test
    public void shouldGetCartoonByName(){
        //Given
        List<Season> seasonList = new ArrayList<>();
        List<UserRating> userRatingList = new ArrayList<>();
        Date date = new GregorianCalendar(1988, 06, 15).getGregorianChange();
        Cartoon cartoon = new Cartoon(1L, "Tom & Jerry", 10, date, seasonList, userRatingList);
        Cartoon cartoon1 = new Cartoon(2L, "Tomas and Friends", 9, date, seasonList, userRatingList);
        List<Cartoon> cartoonList = new ArrayList<>();
        cartoonList.add(cartoon);
        cartoonList.add(cartoon1);
        when(cartoonRepository.findByNameLike("Tom%")).thenReturn(cartoonList);
        //When
        List<CartoonDto>cartoonDtoList = cartoonService.findCartoonByName("Tom");
        //Then
        assertEquals(2, cartoonDtoList.size());
    }

    @Test
    public void shouldUpdateCartoon() {
        //Given
        List<SeasonDto> seasonList = new ArrayList<>();
        List<UserRating> userRatingList = new ArrayList<>();
        Date date = new GregorianCalendar(1988, 06, 15).getGregorianChange();
        CartoonDto cartoonDto = new CartoonDto(1L, "Tom & Jerry", 10, 10, date, seasonList);
        Cartoon cartoon = cartoonMapper.mapToCarton(cartoonDto);
        when(cartoonRepository.findOne(1L)).thenReturn(cartoon);
        //When
        CartoonDto myCartoonDto = cartoonService.updateCartoon(cartoonDto);
        //Then
        assertEquals("Tom & Jerry", myCartoonDto.getName());
    }

    @Test
    public void shouldSaveCartoon() {
        //Given
        List<Season> seasonList = new ArrayList<>();
        List<UserRating> userRatingList = new ArrayList<>();
        Date date = new GregorianCalendar(1988, 06, 15).getGregorianChange();
        Cartoon cartoon = new Cartoon(1L, "Tom & Jerry", 10, date, seasonList, userRatingList);
        //When
        cartoonService.saveCartoon(cartoonMapper.mapToCartoonDto(cartoon));
        //Then
        verify(cartoonRepository, times(1)).save(cartoon);
    }

    @Test
    public void shouldDeleteCartoon() {
        //Given
        List<Season> seasonList = new ArrayList<>();
        List<UserRating> userRatingList = new ArrayList<>();
        Date date = new GregorianCalendar(1988, 06, 15).getGregorianChange();
        Cartoon cartoon = new Cartoon(1L, "Tom & Jerry", 10, date, seasonList, userRatingList);
        //When
        cartoonService.deleteId(cartoon.getId());
        //Then
        verify(cartoonRepository, times(1)).delete(1L);
    }
}