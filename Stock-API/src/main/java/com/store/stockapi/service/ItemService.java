package com.store.stockapi.service;

import com.store.stockapi.model.Item;
import com.store.stockapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Optional<Item> findById(String id){
        return itemRepository.findById(id);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void deleteById(String id){
        itemRepository.deleteById(id);
    }

    public Item update(String id, Item item) {
        Item itemToUpdate = itemRepository.findById(id).orElse(null);
        if (itemToUpdate != null) {
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setQuantity(item.getQuantity());
            return itemRepository.save(itemToUpdate);
        }
        return null;
    }
}
