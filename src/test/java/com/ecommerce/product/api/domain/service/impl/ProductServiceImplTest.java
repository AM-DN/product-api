package com.ecommerce.product.api.domain.service.impl;

import com.ecommerce.product.api.domain.dataprovider.ProductDataProvider;
import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductDataProvider productDataProvider;

    @Test
    void testCreateProduct() {
        Product product = ProductFactory.createProduct();
        Mockito.when(productDataProvider.save(Mockito.any(Product.class))).thenReturn(product);
        ProductServiceImpl productService = new ProductServiceImpl(productDataProvider);
        Product savedOrder = productService.create(product);
        Assertions.assertEquals(product.getProductId(), savedOrder.getProductId());
        Assertions.assertEquals(product.getName(), savedOrder.getName());
        Assertions.assertEquals(product.getQuantity(), savedOrder.getQuantity());
        Assertions.assertEquals(product.getPrice(), savedOrder.getPrice());
    }

}
