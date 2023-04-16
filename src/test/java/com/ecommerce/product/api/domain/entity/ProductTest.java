package com.ecommerce.product.api.domain.entity;

import com.ecommerce.product.api.utils.ProductFactory;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

class ProductTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testWithProductIdNull() {
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(ProductFactory.createProductWithProductIdNull());
        Assertions.assertEquals(1, constraintViolations.size());
    }

}
