package com.store.stockapi.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {


    @Id
    @NonNull
    @Field("client_id")
    @Indexed(unique = true)
    private String id;

    private String firstName;
    private String lastName;
    private String cpf;
    private String phone;
    private String gender;
}
