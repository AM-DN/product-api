package com.ecommerce.product.api.application.mapper;

import com.ecommerce.product.api.application.dto.create.CreateProductCommand;
import com.ecommerce.product.api.application.dto.create.CreateProductResponse;
import com.ecommerce.product.api.application.dto.create.QueryProductResponse;
import com.ecommerce.product.api.domain.entity.Product;

public interface ProductMapper {

    Product toEntityCreate(CreateProductCommand createProductCommand);

    CreateProductResponse toDtoCreate(Product product);

    QueryProductResponse toDtoQuery(Product product);

}
