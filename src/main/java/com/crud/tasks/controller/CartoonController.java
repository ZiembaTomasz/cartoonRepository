package com.crud.tasks.controller;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.domain.CartoonDto;
import com.crud.tasks.service.CartoonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/cartoons")
@RestController
@AllArgsConstructor
public class CartoonController {


    private CartoonService cartoonService;


    @RequestMapping(method = RequestMethod.GET, value = "getCartoons")
    public List<CartoonDto> getCartoons(){

        return cartoonService.getAllCartoons();
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCartoon")
    public CartoonDto  getCartoon(@RequestParam Long cartoonId) {
       return cartoonService.getCartoon(cartoonId);
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCartoonByName")
    public List<CartoonDto> getCartoonByName(@RequestParam String name){
        return cartoonService.findCartoonByName(name);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCartoon")
    public void deleteCartoon(@RequestBody Long cartoonId){
        cartoonService.deleteId(cartoonId);


    }
    @RequestMapping(method = RequestMethod.POST, value = "createCartoon")
    public void createCartoon(@RequestBody CartoonDto cartoonDto){
        cartoonService.saveCartoon(cartoonDto);

    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateCarton")
    public CartoonDto updateCartoon(@RequestBody CartoonDto cartoonDto){
        return cartoonService.saveCartoon(cartoonDto);
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCartoonsFromDate")
    public List<CartoonDto> retrieveNewCartoons(Date date){
        return cartoonService.retrieveNewCartoons(date);

    }
}
