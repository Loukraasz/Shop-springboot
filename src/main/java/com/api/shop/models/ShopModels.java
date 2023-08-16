package com.api.shop.models;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_Products")
public class ShopModels {
    @Id
    @GeneratedValue()
    private UUID idProduct;
    private String name;
    private BigDecimal value;
    private Date validity;
    private Date manufacturing;
    private Integer stock;
   
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public UUID getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public Date getValidity() {
        return validity;
    }
    public void setValidity(Date validity) {
        this.validity = validity;
    }
    public Date getManufacturing() {
        return manufacturing;
    }
    public void setManufacturing(Date manufacturing) {
        this.manufacturing = manufacturing;
    }
    

    
    
}
