package com.ecommerce.product.api.application.controller.v1;

import com.ecommerce.product.api.application.dto.create.CreateProductCommand;
import com.ecommerce.product.api.application.dto.create.CreateProductResponse;
import com.ecommerce.product.api.application.mapper.ProductMapper;
import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.domain.service.ProductService;
import com.ecommerce.product.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class) 
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @Test
    void testCreateProduct() {
        Product product = ProductFactory.createProduct();
        Mockito.when(productService.create(Mockito.any(Product.class))).thenReturn(product);
        Mockito.when(productMapper.toEntityCreate(Mockito.any(CreateProductCommand.class))).thenReturn(product);
        Mockito.when(productMapper.toDtoCreate(Mockito.any(Product.class))).thenReturn(ProductFactory.createProductResponse());
        ProductController orderController = new ProductController(productService, productMapper);
        CreateProductResponse response = orderController.createProduct(ProductFactory.createProductCommand()).getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.productId());
    }

}
