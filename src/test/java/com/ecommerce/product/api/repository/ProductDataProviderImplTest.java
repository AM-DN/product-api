package com.ecommerce.product.api.repository;

import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.infra.repository.ProductRepository;
import com.ecommerce.product.api.infra.repository.impl.ProductDataProviderImpl;
import com.ecommerce.product.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductDataProviderImplTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    void testCreateProduct() {
        Product product = ProductFactory.createProduct();
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        ProductDataProviderImpl productDataProvider = new ProductDataProviderImpl(productRepository);
        Product savedOrder = productDataProvider.save(product);
        Assertions.assertEquals(product.getId(), savedOrder.getId());
        Assertions.assertEquals(product.getProductId(), savedOrder.getProductId());
        Assertions.assertEquals(product.getName(), savedOrder.getName());
        Assertions.assertEquals(product.getQuantity(), savedOrder.getQuantity());
        Assertions.assertEquals(product.getPrice(), savedOrder.getPrice());
    }

}
