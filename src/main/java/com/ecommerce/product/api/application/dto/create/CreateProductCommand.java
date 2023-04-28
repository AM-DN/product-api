package com.ecommerce.product.api.application.dto.create;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProductCommand(

    @NotNull(message = "name must be informed") 
    String name,

    @NotNull(message = "price must be informed")
    BigDecimal price
) {

}
