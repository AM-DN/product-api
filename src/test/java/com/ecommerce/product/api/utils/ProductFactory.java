package com.ecommerce.product.api.utils;

import com.ecommerce.product.api.application.dto.create.CreateProductCommand;
import com.ecommerce.product.api.application.dto.create.CreateProductResponse;
import com.ecommerce.product.api.domain.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

public final class ProductFactory {

    public static Product createProduct() {
      return Product.builder()
              .id(1L)
              .productId(UUID.randomUUID())
              .name("MackBook")
              .price(new BigDecimal(5000))
              .build();
    }

    public static CreateProductCommand createProductCommand() {
        return new CreateProductCommand("Macbook", new BigDecimal(23));
    }

    public static CreateProductResponse createProductResponse() {
        return new CreateProductResponse(UUID.randomUUID());
    }

    public static Product createProductWithProductIdNull() {
        return Product.builder()
                .id(1L)
                .productId(null)
                .name("Macbook")
                .price(new BigDecimal(5000))
                .build();
    }

}
