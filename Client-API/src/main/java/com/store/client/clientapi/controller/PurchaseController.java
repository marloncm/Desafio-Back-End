package com.store.client.clientapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.client.clientapi.exception.InsufficientStockException;
import com.store.client.clientapi.exception.ItemNotFoundException;
import com.store.client.clientapi.model.Item;
import com.store.client.clientapi.model.Purchase;
import com.store.client.clientapi.queue.QueueSender;
import com.store.client.clientapi.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        List<Purchase> purchases = purchaseService.findAll();

        if (purchases.isEmpty()) {
            log.warn("No purchases found");
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            log.info("Fetched {} purchases", purchases.size());
            return ResponseEntity.ok(purchases); // 200 OK
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable String id) {
        //return purchaseService.findById(id);
        log.info("Fetching purchase with ID: {}", id);
        return purchaseService.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getPurchasesByClientId(@PathVariable String id) {
        List<Purchase> purchases = purchaseService.findByClientId(id);

        if (purchases.isEmpty()) {
            log.warn("No purchases found for client with ID: {}", id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            log.info("Fetched {} purchases for client with ID: {}", purchases.size(), id);
            return ResponseEntity.ok(purchases); // 200 OK
        }
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {

        //TODO: testar se todos os itens possuem a quantidade em estoque
        String url = "http://localhost:8082/stock/items/";

        for (Item item: purchase.getItems()){
            Item itemStock = restTemplate.getForObject(url + item.getSku(), Item.class);

            if (itemStock == null) {
                throw new ItemNotFoundException(item.getSku());
            } else if (itemStock.getQuantity() < item.getQuantity()) {
                throw new InsufficientStockException(item.getSku());
            }
        }


        try{
            String purchaseJson = objectMapper.writeValueAsString(purchase);
            queueSender.send(purchaseJson);
            log.info("Purchase sent to queue: {}", purchaseJson);
        }catch (JsonProcessingException e){
            log.error("Error sending purchase to queue: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


        Purchase newPurchase = purchaseService.save(purchase);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPurchase.getId())
                .toUri();
        return ResponseEntity.created(location).body(newPurchase);
    }

    @PutMapping("{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable String id, @RequestBody Purchase purchase) {
        Purchase updatedPurchase = purchaseService.update(id, purchase);

        if (updatedPurchase == null) {
            log.warn("Purchase with ID: {} not found", id);
            return ResponseEntity.notFound().build(); // 404 Not Found
        } else {
            log.info("Purchase with ID: {} updated", id);
            return ResponseEntity.ok(updatedPurchase); // 200 OK
        }
    }
}
