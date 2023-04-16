package com.ecommerce.product.api.domain.dataprovider;

import com.ecommerce.product.api.domain.entity.Product;

import java.util.UUID;

public interface ProductDataProvider {

    Product save(Product product);

    Product findByProduct(UUID productId);
}
