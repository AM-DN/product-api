package com.ecommerce.product.api.application.controller.v1;

import com.ecommerce.product.api.application.dto.create.CreateProductCommand;
import com.ecommerce.product.api.application.dto.create.CreateProductResponse;
import com.ecommerce.product.api.application.dto.create.QueryProductResponse;
import com.ecommerce.product.api.application.mapper.ProductMapper;
import com.ecommerce.product.api.domain.entity.Product;
import com.ecommerce.product.api.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductCommand createProductCommand) {
        Product product = productMapper.toEntityCreate(createProductCommand);
        return new ResponseEntity<>(productMapper.toDtoCreate(productService.create(product)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<QueryProductResponse> getByProductId(@PathVariable UUID productId) {
        return new ResponseEntity<>(productMapper.toDtoQuery(productService.getByProductId(productId)), HttpStatus.OK);
    }

}
