package com.store.client.clientapi.service;

import com.store.client.clientapi.model.Client;
import com.store.client.clientapi.repository.ClientReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientReposiroty clientReposiroty;

    public List<Client> findAll(){
        return clientReposiroty.findAll();
    }

    public Optional<Client> findById(String id){
        return clientReposiroty.findById(id);
    }

    public Client save(Client client){
        return clientReposiroty.save(client);
    }

    public void deleteById(String id){
        clientReposiroty.deleteById(id);
    }

}
