package com.store.client.clientapi.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Client {

    @Id
    @NonNull
    private String id;

    private String firstName;
    private String lastName;
    private String cpf;
    private String phone;
    private String gender;

    public Client() {
    }

    public Client(String firstName, String lastName, String cpf, String phone, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phone = phone;
        this.gender = gender;
    }

    public Client(String id, String firstName, String lastName, String cpf, String phone, String gender){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
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
                        "  \"firstName\": \"%s\",\n" +
                        "  \"lastName\": \"%s\",\n" +
                        "  \"cpf\": \"%s\",\n" +
                        "  \"phone\": \"%s\",\n" +
                        "  \"gender\": \"%s\"\n" +
                        "}",
                id,
                firstName != null ? firstName : "null",
                lastName != null ? lastName : "null",
                cpf != null ? cpf : "null",
                phone != null ? phone : "null",
                gender != null ? gender : "null"
        );
    }

}
