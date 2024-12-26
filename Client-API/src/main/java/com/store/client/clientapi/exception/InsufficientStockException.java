package com.store.client.clientapi.exception;

public class InsufficientStockException extends RuntimeException{

    public InsufficientStockException(String sku) {
        super("Item with SKU " + sku + " has insufficient stock.");
    }
}
