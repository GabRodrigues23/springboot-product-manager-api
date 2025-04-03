package com.spring.manager.service;

import org.springframework.stereotype.Service;

import com.spring.manager.dto.ClientDTO;
import com.spring.manager.entity.Client;
import com.spring.manager.repository.ClientRepository;

import java.util.List;
import jakarta.transaction.Transactional;

@Service
public class ClientService {
    
    private final ClientRepository repository;
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    // Create
    @Transactional
    public ClientDTO create(ClientDTO clientDTO) {
        Client client = toEntity(clientDTO);
        Client savedClient = repository.save(client);
        return toDTO(savedClient);
    }

    // Read (List All)
    public List<ClientDTO> listAll() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    // Read (By Id)
    public ClientDTO listById(long id) {
        return repository.findById(id)
            .map(this::toDTO)
            .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // Update
    @Transactional
    public ClientDTO update(long id, ClientDTO clientDTO) {
        Client client = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setCep(clientDTO.getCep());
        client.setPhone(clientDTO.getPhone());
        // client.setSales(clientDTO.getSales());

        return toDTO(repository.save(client));
    }

    // Delete
    @Transactional
    public void delete(long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        repository.deleteById(id);
    }

    // Utility
    private ClientDTO toDTO(Client client) {
        return new ClientDTO(
            client.getId(), 
            client.getName(), 
            client.getCpf(), 
            client.getCep(), 
            client.getPhone()
            // client.getSales()
        );
    }

    private Client toEntity(ClientDTO dto) {
        return new Client(
            dto.getId(), 
            dto.getName(), 
            dto.getCpf(), 
            dto.getCep(), 
            dto.getPhone()
            // dto.getSales()
        );
    }
}
