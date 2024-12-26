package com.store.client.clientapi.repository;

import com.store.client.clientapi.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientReposiroty extends MongoRepository<Client, String> {
}
