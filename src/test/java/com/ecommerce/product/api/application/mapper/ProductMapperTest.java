package com.ecommerce.product.api.application.mapper;

import com.ecommerce.product.api.application.dto.create.CreateProductCommand;
import com.ecommerce.product.api.application.dto.create.CreateProductResponse;
import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductMapperTest {

    private final ProductMapper productMapper = new ProductMapperImpl();

    @Test
    void testToEntity() {
        CreateProductCommand createProductCommand = ProductFactory.createProductCommand();
        Product entity = productMapper.toEntityCreate(createProductCommand);
        Assertions.assertEquals(createProductCommand.name(), entity.getName());
    }

    @Test
    void testToDto() {
        Product order = ProductFactory.createProduct();
        CreateProductResponse createProductResponse = productMapper.toDtoCreate(order);
        Assertions.assertEquals(order.getProductId(), createProductResponse.productId());
    }

}
