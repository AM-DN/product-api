package com.ecommerce.product.api.domain.service;

import com.ecommerce.product.api.domain.entity.Product;

import java.util.UUID;

public interface ProductService {

    Product create(Product product);

    Product getByProductId(UUID productId);

}
