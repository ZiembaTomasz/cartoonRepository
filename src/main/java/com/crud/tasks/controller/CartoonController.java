package com.crud.tasks.controller;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.domain.CartoonDto;
import com.crud.tasks.mapper.CartoonMapper;
import com.crud.tasks.repository.CartoonRepository;
import com.crud.tasks.service.CartoonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/cartoons")
@RestController
@AllArgsConstructor
public class CartoonController {

    private CartoonMapper cartoonMapper;
    private CartoonService cartoonService;


    @RequestMapping(method = RequestMethod.GET, value = "getCartoons")
    public List<CartoonDto> getCartoons(){

        return cartoonMapper.mapToCartoonDtoList(cartoonService.getAllCartoons());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCartoon")
    public CartoonDto  getCartoon(@RequestParam Long cartonId) {
       return cartoonMapper.mapToCartoonDto(cartoonService.getCartoon(cartonId));
    }
    public String getCartoonByName(String name){
        return null;
    }

    public void getCartoonBySeason(int season, String name){

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCartoon")
    public void deleteCartoon(@RequestBody Long cartoonId){
        cartoonService.deleteId(cartoonId);


    }
    @RequestMapping(method = RequestMethod.POST, value = "createCartoon")
    public void createCartoon(@RequestBody CartoonDto cartoonDto){
        cartoonService.saveCartoon(cartoonMapper.mapToCarton(cartoonDto));

    }

}
