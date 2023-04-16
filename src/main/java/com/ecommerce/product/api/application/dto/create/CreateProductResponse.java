package com.ecommerce.product.api.application.dto.create;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateProductResponse(
        @NotNull
        UUID productId
) {
}
