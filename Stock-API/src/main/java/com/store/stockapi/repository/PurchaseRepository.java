package com.store.stockapi.repository;

import com.store.stockapi.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}
