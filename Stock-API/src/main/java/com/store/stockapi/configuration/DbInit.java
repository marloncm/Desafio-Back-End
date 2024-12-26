package com.store.stockapi.configuration;


import com.store.stockapi.model.Item;
import com.store.stockapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration      // This annotation is not needed for this class to run
public class DbInit implements CommandLineRunner {

    private final ItemRepository itemRepository;

    @Autowired
   public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // Reset DB
        itemRepository.deleteAll();

        List<Item> items = Arrays.asList(
                new Item("SKU1", 10.0, 5L),
                new Item("SKU2", 20.0, 3L),
                new Item("SKU3", 15.0, 10L),
                new Item("SKU4", 5.0, 50L),
                new Item("SKU5", 100.0, 1L),
                new Item("SKU6", 75.0, 2L),
                new Item("SKU7", 25.0, 7L),
                new Item("SKU8", 30.0, 40L),
                new Item("SKU9", 8.0, 15L),
                new Item("SKU10", 12.0, 8L),
                new Item("SKU11", 45.0, 6L),
                new Item("SKU12", 90.0, 3L),
                new Item("SKU13", 65.0, 4L),
                new Item("SKU14", 120.0, 2L),
                new Item("SKU15", 35.0, 9L),
                new Item("SKU16", 60.0, 11L),
                new Item("SKU17", 55.0, 5L),
                new Item("SKU18", 85.0, 7L),
                new Item("SKU19", 50.0, 4L),
                new Item("SKU20", 40.0, 3L)
        );
       itemRepository.saveAll(items);
        System.out.println("Database initialized with items.");
    }
}
