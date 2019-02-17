package com.crud.tasks.service;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.domain.CartoonDto;
import com.crud.tasks.mapper.CartoonMapper;
import com.crud.tasks.repository.CartoonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartoonService {

    private CartoonRepository cartoonRepository;
    private CartoonMapper cartoonMapper;

    public List<CartoonDto> getAllCartoons() {
        return cartoonMapper.mapToCartoonDtoList(cartoonRepository.findAll());
    }

    public CartoonDto saveCartoon(final CartoonDto cartoonDto) {
        Cartoon cartoon = cartoonMapper.mapToCarton(cartoonDto);
        cartoon = cartoonRepository.save(cartoon);
        return cartoonMapper.mapToCartoonDto(cartoon);
    }

    public void deleteId(final Long id) {
        cartoonRepository.delete(id);
    }

    public CartoonDto getCartoon(final Long id) {
        return cartoonMapper.mapToCartoonDto(cartoonRepository.getOne(id));
    }

    public List<CartoonDto> findCartoonByName(String name) {
        List<Cartoon>cartoons = cartoonRepository.findByNameLike(name + "%");
        return cartoonMapper.mapToCartoonDtoList(cartoons);
    }
}
