package com.ecommerce.product.api.application.mapper;

import com.ecommerce.product.api.application.dto.create.CreateProductCommand;
import com.ecommerce.product.api.application.dto.create.CreateProductResponse;
import com.ecommerce.product.api.application.dto.create.QueryProductResponse;
import com.ecommerce.product.api.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntityCreate(CreateProductCommand createProductCommand) {
        return Product.builder()
                .productId(UUID.randomUUID())
                .name(createProductCommand.name())
                .price(createProductCommand.price())
                .build();
    }

    @Override
    public CreateProductResponse toDtoCreate(Product product) {
        return new CreateProductResponse(product.getProductId());
    }

    @Override
    public QueryProductResponse toDtoQuery(Product product) {
        return new QueryProductResponse(
                product.getPrice()
        );
    }

}
