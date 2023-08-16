package com.api.shop.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.shop.models.ShopModels;

@Repository
public interface ShopRepository extends JpaRepository<ShopModels, UUID>{

   Optional<ShopModels> existsByName(String name);
        
    
    
}
