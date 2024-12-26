package com.store.client.clientapi.model;

import com.mongodb.lang.NonNull;
import com.store.client.clientapi.enums.PaymentType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Purchase {

    @Id
    @Field("id_purchase")
    @NonNull

    private String id;

    @DBRef
    private Client client;

    @DBRef
    private List<Item> items = new ArrayList<>();

    private Double total;
    private PaymentType paymentType;

    public Purchase() {
    }

    public Purchase(Client client, List<Item> items, Double total, PaymentType paymentType) {
        this.client = client;
        this.items = items;
        this.total = total;
        this.paymentType = paymentType;
    }

    public Purchase(String id, Client client, List<Item> items, Double total, PaymentType paymentType) {
        this.id = id;
        this.client = client;
        this.items = items;
        this.total = total;
        this.paymentType = paymentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"id\": \"%s\",\n" +
                        "  \"clientId\": \"%s\",\n" +
                        "  \"itemIds\": %s,\n" +
                        "  \"total\": %.2f,\n" +
                        "  \"paymentType\": \"%s\"\n" +
                        "}",
                id,
                client != null ? client.getId() : "null",  // Get client ID only
                items != null ? items.stream().map(Item::getSku).toList() : "[]",  // Get item IDs only
                total != null ? total : 0.0,
                paymentType != null ? paymentType.toString() : "null"
        );
    }



}
