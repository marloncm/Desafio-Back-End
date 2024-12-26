package com.store.stockapi.controller;

import com.store.stockapi.model.Item;
import com.store.stockapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable String id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteById(id);
    }
}
