package com.store.stockapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @NonNull
    @Indexed(unique = true)
    @Field("item_id")
    private String sku;

    private Double price;

    private Long quantity;
}
