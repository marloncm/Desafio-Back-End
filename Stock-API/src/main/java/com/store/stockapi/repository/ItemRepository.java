package com.store.stockapi.repository;

import com.store.stockapi.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
