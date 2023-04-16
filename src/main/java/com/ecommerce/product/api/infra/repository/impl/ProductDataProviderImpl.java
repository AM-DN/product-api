package com.ecommerce.product.api.infra.repository.impl;

import com.ecommerce.product.api.application.handler.wrapper.ErrorMessage;
import com.ecommerce.product.api.application.handler.wrapper.ErrorRequestVO;
import com.ecommerce.product.api.domain.dataprovider.ProductDataProvider;
import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.infra.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductDataProviderImpl implements ProductDataProvider {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        verifyProduct(product);
        return productRepository.save(product);
    }

    @Override
    public Product findByProduct(UUID productId) {
        return productRepository.findByProductId(productId)
            .orElseThrow(() -> new ErrorRequestVO(ErrorMessage.PRODUCT_NOT_FOUND));
    }

    public boolean verifyProduct(Product product) {
        var newProduct = productRepository.findByName(product.getName());
        if (newProduct.isPresent()) {
            throw new ErrorRequestVO(ErrorMessage.PRODUCT_ALREADY_EXIST);
        }
        return true;
    }

}
