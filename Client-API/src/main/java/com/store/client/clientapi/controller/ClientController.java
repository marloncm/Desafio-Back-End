package com.store.client.clientapi.controller;

import com.store.client.clientapi.model.Client;
import com.store.client.clientapi.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/store/clients")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = clientService.findAll();

        if (clients.isEmpty()) {
            logger.warn("No clients found");
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            logger.info("Fetched {} clients", clients.size());
            return ResponseEntity.ok(clients); // 200 OK
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        logger.info("Fetching client with ID: {}", id);
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.save(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdClient.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdClient);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        if (clientService.findById(id).isPresent()) {
            clientService.deleteById(id);
            return ResponseEntity.noContent().build(); //204 if deleted
        } else {
            return ResponseEntity.notFound().build(); //404 if id not found
        }
    }

}
