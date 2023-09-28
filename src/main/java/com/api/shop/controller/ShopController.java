package com.api.shop.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shop.models.ShopModels;
import com.api.shop.repository.ShopRepository;
import com.api.shop.shopDto.ShopDto;

import jakarta.validation.Valid;

@RestController
public class ShopController {
    @Autowired
    ShopRepository shopRepository;

    /*metodo post, bem basico porem funcional */
    @PostMapping("/products")
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ShopDto shopDto){
        Optional<ShopModels> product = shopRepository.existsByName(shopDto.name());
        if(product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product already exists");
        }
        var shopModels = new ShopModels();
        BeanUtils.copyProperties(shopDto, shopModels);
        return ResponseEntity.status(HttpStatus.CREATED).body(shopRepository.save(shopModels));
        
    }
    /*metodo GetAll, esse metodo retorna uma lista com todos os registros do banco de dados */
    @GetMapping("/products")
    public ResponseEntity<List<ShopModels>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(shopRepository.findAll());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Object>getOne(@PathVariable(value="id") UUID id){
        Optional<ShopModels> product = shopRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
            return ResponseEntity.status(HttpStatus.OK).body(shopRepository.findById(id));
    }
    /*metodo put, utilizado para atualizar os registros */
    @PutMapping("/products/{id}")
    public ResponseEntity<Object>update(@PathVariable(value="id") UUID id, @RequestBody @Valid ShopDto shopDto){
        Optional<ShopModels> product = shopRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
            var product0 = product.get();
            BeanUtils.copyProperties(shopDto, product0);
            return ResponseEntity.status(HttpStatus.OK).body(shopRepository.save(product0));
    }
    /*metodo delete, usado para deletar um registro */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object>delete(@PathVariable(value="id") UUID id){
        Optional<ShopModels> product = shopRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
            var product0 = product.get();
            shopRepository.delete(product0);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
    /*alguns metodos precisam do id do registro que voce quer alterar, apagar ou retornar */
    
    
}
