package com.spring.manager.controller;

import com.spring.manager.dto.ClientDTO;
import com.spring.manager.service.ClientService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/manager/clients")
public class ClientController {

    private final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO) {
        ClientDTO clientCreated = service.create(clientDTO);
        return ResponseEntity.created(URI.create("/client/" + clientCreated.getId())).body(clientCreated);
    }

    // Read All
    @GetMapping("/readAll")
    public List<ClientDTO> listAll() {
        return service.listAll();
    }

    // Read By Id
    @GetMapping("/readById/{id}")
    public ResponseEntity<ClientDTO> listById(@PathVariable long id) {
        return ResponseEntity.ok(service.listById(id));
    }
    
    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        ClientDTO clientUpdated = service.update(id, clientDTO);
        return clientUpdated != null ? ResponseEntity.ok(clientUpdated) : ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
