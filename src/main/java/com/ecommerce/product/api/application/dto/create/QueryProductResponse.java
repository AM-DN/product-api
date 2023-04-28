package com.ecommerce.product.api.application.dto.create;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record QueryProductResponse(

    @NotNull
    BigDecimal price

) {
}
