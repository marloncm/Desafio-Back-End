package com.store.client.clientapi.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Item {

    @Id
    @NonNull
    @Indexed(unique = true)
    private String sku;

    private Double price;

    private Long quantity;

    public Item() {
    }

    public Item(Double price, Long quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String sku, Double price, Long quantity) {
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sku);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"sku\": \"%s\",\n" +
                        "  \"price\": %.2f,\n" +
                        "  \"quantity\": %d\n" +
                        "}",
                sku,
                price != null ? price : 0.0,
                quantity != null ? quantity : 0L
        );
    }

}
