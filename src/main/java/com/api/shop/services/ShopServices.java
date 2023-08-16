package com.api.shop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.shop.models.ShopModels;
import com.api.shop.repository.ShopRepository;

public class ShopServices {
    @Autowired
    ShopRepository shopRepository;

    public Optional<ShopModels> existsByName(String name){
        return shopRepository.existsByName(name);
    }
    
}
