package com.store.client.clientapi.repository;

import com.store.client.clientapi.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
    List<Purchase> findByClientId(String clientId);
}
