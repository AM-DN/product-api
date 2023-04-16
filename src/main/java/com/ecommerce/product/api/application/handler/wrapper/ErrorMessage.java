package com.ecommerce.product.api.application.handler.wrapper;

public class ErrorMessage {

    private ErrorMessage() {
        throw new UnsupportedOperationException("This a utility class and cannot be instantiated");
    }

    public static final String PRODUCT_NOT_FOUND = "The product doesn't exist";
    public static final String PRODUCT_ALREADY_EXIST = "This product already exists, please see it in the catalog";

}
