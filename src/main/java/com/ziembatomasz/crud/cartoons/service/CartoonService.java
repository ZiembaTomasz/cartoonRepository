package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.Cartoon;
import com.ziembatomasz.crud.cartoons.domain.CartoonDto;
import com.ziembatomasz.crud.cartoons.mapper.CartoonMapper;
import com.ziembatomasz.crud.cartoons.repository.CartoonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Data
public class CartoonService {

    private CartoonRepository cartoonRepository;
    private CartoonMapper cartoonMapper;

    public List<CartoonDto> getAllCartoons() {
        return cartoonMapper.mapToCartoonDtoList(cartoonRepository.findAll());
    }

    public CartoonDto updateCartoon(final CartoonDto cartoonDto) {
        Contracts.assertNotNull(cartoonDto.getId(), "Cannot update without ID");
        Contracts.assertNotNull(cartoonRepository.findOne(cartoonDto.getId()));
        Cartoon cartoon = cartoonMapper.mapToCarton(cartoonDto);
        cartoonRepository.save(cartoon);
        return cartoonMapper.mapToCartoonDto(cartoon);
    }
    public void saveCartoon(final CartoonDto cartoonDto){
        Contracts.assertTrue(cartoonDto.getId() != null, "Cannot create cartoon with id");
        Cartoon cartoon = cartoonMapper.mapToCarton(cartoonDto);
        cartoonRepository.save(cartoon);

    }
    public void deleteId(final Long id) {
        cartoonRepository.delete(id);
    }

    public CartoonDto getCartoon(final Long id) {
        return cartoonMapper.mapToCartoonDto(cartoonRepository.getOne(id));
    }

    public List<CartoonDto> findCartoonByName(String name) {
        List<Cartoon> cartoons = cartoonRepository.findByNameLike(name + "%");
        return cartoonMapper.mapToCartoonDtoList(cartoons);
    }

    public List<CartoonDto> retrieveNewCartoons(Date date) {
        List<Cartoon> cartoons = cartoonRepository.retrieveNewCartoons(date);
        return cartoonMapper.mapToCartoonDtoList(cartoons);
    }
}
