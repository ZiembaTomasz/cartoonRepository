package com.crud.tasks.service;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.domain.CartoonDto;
import com.crud.tasks.mapper.CartoonMapper;
import com.crud.tasks.repository.CartoonRepository;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CartoonService {

    private CartoonRepository cartoonRepository;
    private CartoonMapper cartoonMapper;

    public List<CartoonDto> getAllCartoons() {
        return cartoonMapper.mapToCartoonDtoList(cartoonRepository.findAll());
    }

    public CartoonDto updateCartoon(final CartoonDto cartoonDto) {
        Contracts.assertNotNull(cartoonDto.getId(), "Cannot update without ID");
        Contracts.assertNotNull(cartoonRepository.findOne(cartoonDto.getId()), "Cartoon doesnt exist in database");
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
