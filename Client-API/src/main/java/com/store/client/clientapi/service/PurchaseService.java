package com.store.client.clientapi.service;

import com.store.client.clientapi.model.Purchase;
import com.store.client.clientapi.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAll(){
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> findById(String id){
        return purchaseRepository.findById(id);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public void deleteById(String id){
        purchaseRepository.deleteById(id);
    }

    public List<Purchase> findByClientId(String clientId){
        return purchaseRepository.findByClientId(clientId);
    }

    public Purchase update(String id, Purchase purchase) {
        Purchase purchaseToUpdate = purchaseRepository.findById(id).orElse(null);
        if (purchaseToUpdate != null) {
            purchaseToUpdate.setClient(purchase.getClient());
            purchaseToUpdate.setItems(purchase.getItems());
            purchaseToUpdate.setTotal(purchase.getTotal());
            purchaseToUpdate.setPaymentType(purchase.getPaymentType());
            return purchaseRepository.save(purchaseToUpdate);
        }
        return null;
    }
}
