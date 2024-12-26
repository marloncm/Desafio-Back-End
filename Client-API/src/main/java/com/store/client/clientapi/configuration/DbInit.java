package com.store.client.clientapi.configuration;

import com.store.client.clientapi.enums.PaymentType;
import com.store.client.clientapi.model.Client;
import com.store.client.clientapi.model.Item;
import com.store.client.clientapi.model.Purchase;
import com.store.client.clientapi.repository.ClientReposiroty;
import com.store.client.clientapi.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

//@Configuration        // This annotation is not needed for this class to run
public class DbInit implements CommandLineRunner {

    //private final ClientReposiroty clientRepository;
    //private final ItemRepository itemRepository;
    //private final PurchaseRepository purchaseRepository;

   // @Autowired
   /* public DbInit(ClientReposiroty clientRepository, ItemRepository itemRepository, PurchaseRepository purchaseRepository) {
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
        this.purchaseRepository = purchaseRepository;
    }*/


    @Override
    public void run(String... args) throws Exception {
        // Reset DB
        //clientRepository.deleteAll();
        //itemRepository.deleteAll();
        //purchaseRepository.deleteAll();

        List<Client> clients = Arrays.asList(
                new Client("1", "John", "Doe", "12345678901", "555-1234", "Male"),
                new Client("2", "Jane", "Smith", "98765432100", "555-5678", "Female"),
                new Client("3", "Alice", "Johnson", "11122233344", "555-6789", "Female"),
                new Client("4", "Bob", "Brown", "22233344455", "555-8765", "Male"),
                new Client("5", "Charlie", "Davis", "33344455566", "555-4321", "Male"),
                new Client("6", "Daisy", "Evans", "44455566677", "555-2468", "Female"),
                new Client("7", "Ethan", "Wilson", "55566677788", "555-1357", "Male"),
                new Client("8", "Fiona", "Thomas", "66677788899", "555-9753", "Female"),
                new Client("9", "George", "White", "77788899900", "555-7531", "Male"),
                new Client("10", "Hannah", "Hall", "88899900011", "555-9512", "Female")
        );
        //clientRepository.saveAll(clients);

        List<Item> items = Arrays.asList(
                new Item("SKU1", 10.0, 5L),
                new Item("SKU2", 20.0, 3L),
                new Item("SKU3", 15.0, 10L),
                new Item("SKU4", 5.0, 50L),
                new Item("SKU5", 100.0, 1L),
                new Item("SKU6", 75.0, 2L),
                new Item("SKU7", 25.0, 7L),
                new Item("SKU8", 30.0, 4L),
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
       // itemRepository.saveAll(items);

        List<Purchase> purchases = Arrays.asList(
                new Purchase("PUR1", clients.get(0), Arrays.asList(items.get(0), items.get(1)), 30.0, PaymentType.CREDIT_CARD),
                new Purchase("PUR2", clients.get(1), Arrays.asList(items.get(2), items.get(3)), 20.0, PaymentType.DEBIT_CARD),
                new Purchase("PUR3", clients.get(2), Arrays.asList(items.get(4), items.get(5)), 175.0, PaymentType.CASH),
                new Purchase("PUR4", clients.get(3), Arrays.asList(items.get(6), items.get(7)), 55.0, PaymentType.CASH),
                new Purchase("PUR5", clients.get(4), Arrays.asList(items.get(8), items.get(9)), 20.0, PaymentType.CREDIT_CARD)
        );
        //purchaseRepository.saveAll(purchases);

        System.out.println("Database initialized with clients, items, and purchases.");
    }
}
