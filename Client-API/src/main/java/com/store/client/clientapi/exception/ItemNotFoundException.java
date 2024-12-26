package com.store.client.clientapi.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String sku) {
        super("Item with SKU " + sku + " not found in stock.");
    }
}
