package com.ecommerce.product.api.application.dto.create;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record QueryProductResponse(

    @NotNull
    String name,

    @NotNull
    Long quantity,

    @NotNull
    BigDecimal price

) {
}
