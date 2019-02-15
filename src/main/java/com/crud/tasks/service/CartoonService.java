package com.crud.tasks.service;

import com.crud.tasks.domain.Cartoon;
import com.crud.tasks.repository.CartoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoonService {
    @Autowired
    private CartoonRepository cartoonRepository;

    public List<Cartoon> getAllCartoons(){
        return cartoonRepository.findAll();
    }
    public Cartoon saveCartoon (final Cartoon cartoon){
        return cartoonRepository.save(cartoon);
    }
    public void deleteId(final Long id){
        cartoonRepository.delete(id);
    }
    public Cartoon getCartoon(final Long id){
        return cartoonRepository.getOne(id);
    }

}
