package com.ecommerce.product.api.infra.repository;

import com.ecommerce.product.api.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByProductId(UUID productId);

    Optional<Product> findByName(String name);

}
