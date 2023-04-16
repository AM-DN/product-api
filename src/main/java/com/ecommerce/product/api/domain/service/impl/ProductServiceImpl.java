package com.ecommerce.product.api.domain.service.impl;

import com.ecommerce.product.api.domain.dataprovider.ProductDataProvider;
import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDataProvider productDataProvider;

    @Override
    @Transactional
    public Product create(Product product) {
        return productDataProvider.save(product);
    }

    @Override
    public Product getByProductId(UUID productId) {
        return productDataProvider.findByProduct(productId);
    }

}
