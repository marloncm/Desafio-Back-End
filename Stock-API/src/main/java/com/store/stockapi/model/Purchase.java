package com.store.stockapi.model;

import com.mongodb.lang.NonNull;
import com.store.stockapi.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id
    @NonNull
    @Indexed(unique = true)
    @Field("purchase_id")
    private String id;

    @DBRef
    private Client client;

    @DBRef
    private List<Item> items = new ArrayList<>();

    private Double total;
    private PaymentType paymentType;
}
