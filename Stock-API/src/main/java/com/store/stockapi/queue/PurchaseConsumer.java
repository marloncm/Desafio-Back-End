package com.store.stockapi.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.stockapi.model.Item;
import com.store.stockapi.model.Purchase;
import com.store.stockapi.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseConsumer {

    private static final Logger log = LoggerFactory.getLogger(PurchaseConsumer.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = {"${queue.name}"})
    public void receiveMessage(String purchaseJson) {
        try {

            Purchase purchase = objectMapper.readValue(purchaseJson, Purchase.class);

            for (Item item : purchase.getItems()) {
                Item stockItem = itemService.findById(item.getSku()).orElseThrow(() ->
                        new RuntimeException("Item not found with ID: " + item.getSku())
                );

                stockItem.setQuantity(stockItem.getQuantity() - item.getQuantity());
                itemService.save(stockItem);
            }

        } catch (Exception e) {
            log.error("Error processing purchase: ", e);
        }
    }
}














