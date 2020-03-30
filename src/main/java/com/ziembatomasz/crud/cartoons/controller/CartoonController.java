package com.ziembatomasz.crud.cartoons.controller;

import com.ziembatomasz.crud.cartoons.domain.CartoonDto;
import com.ziembatomasz.crud.cartoons.service.CartoonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/cartoons")
@RestController
@AllArgsConstructor
public class CartoonController {


    private CartoonService cartoonService;


    @GetMapping(value = "/getCartoons")
    public List<CartoonDto> getCartoons() {
        return cartoonService.getAllCartoons();
    }

    @GetMapping(value = "/getCartoon")
    public CartoonDto getCartoon(@RequestParam Long cartoonId) {
        return cartoonService.getCartoon(cartoonId);
    }

    @GetMapping(value = "/getCartoonByName")
    public List<CartoonDto> getCartoonByName(@RequestParam String name) {
        return cartoonService.findCartoonByName(name);
    }

    @DeleteMapping(value = "/deleteCartoon")
    public void deleteCartoon(@RequestBody Long cartoonId) {
        cartoonService.deleteId(cartoonId);
    }

    @PostMapping(value = "/createCartoon")
    public void createCartoon(@RequestBody CartoonDto cartoonDto) {
        cartoonService.saveCartoon(cartoonDto);
    }

    @PutMapping(value = "/updateCarton")
    public CartoonDto updateCartoon(@RequestBody CartoonDto cartoonDto) {
        return cartoonService.updateCartoon(cartoonDto);
    }

    @GetMapping(value = "/getCartoonsFromDate")
    public List<CartoonDto> retrieveNewCartoons(Date date) {
        return cartoonService.retrieveNewCartoons(date);
    }
}
