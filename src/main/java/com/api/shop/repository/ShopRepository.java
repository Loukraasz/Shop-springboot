package com.api.shop.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.shop.models.ShopModels;

@Repository
public interface ShopRepository extends JpaRepository<ShopModels, UUID>{

   /* Metodo que sera utlizado no ShopController para realizar um getOne pelo nome, esse metodo basicamente verifica se existe um usuario com
    * esse nome, o nome deve ser um parametro
    */
   Optional<ShopModels> existsByName(String name);
        
    
    
}
