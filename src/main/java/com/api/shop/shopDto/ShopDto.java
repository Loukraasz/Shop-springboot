package com.api.shop.shopDto;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShopDto(@NotBlank String name, @NotNull BigDecimal value, @NotNull Date validity, @NotNull Date manufacturing, @NotNull Integer stock) {
    
}
