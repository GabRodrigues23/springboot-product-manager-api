package com.spring.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.manager.dto.SaleDTO;
import com.spring.manager.entity.Sale;
import com.spring.manager.repository.SaleRepository;

import jakarta.transaction.Transactional;

@Service
public class SaleService {
    
    private final SaleRepository repository;
    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    // Create
    @Transactional
    public SaleDTO create(SaleDTO saleDTO) {
        Sale sale = toEntity(saleDTO);
        Sale savedSale = repository.save(sale);
        return toDTO(savedSale);
    }

    // Read (List All)
    public List<SaleDTO> listAll() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    // Read (By Id)
    public SaleDTO listById(long id) {
        return repository.findById(id)
            .map(this::toDTO).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update
    @Transactional
    public SaleDTO update(long id, SaleDTO saleDTO) {
        Sale sale = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        sale.setTotalPrice(saleDTO.getTotalPrice());
        sale.setDiscount(saleDTO.getDiscount());
        sale.setItemsQuantity(saleDTO.getItemsQuantity());
        sale.setPayment(saleDTO.getPayment());
        // sale.setProducts(saleDTO.getProducts());
        // sale.setClients(saleDTO.getClients());

        return toDTO(repository.save(sale));
    }

    // Delete
    @Transactional
    public void delete(long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Product not foud");
        }
        repository.deleteById(id);
    }

    // Utilitary
    private SaleDTO toDTO(Sale sale) {
        return new SaleDTO(
            sale.getId(),
            sale.getTotalPrice(),
            sale.getDiscount(),
            sale.getItemsQuantity(),
            sale.getPayment()
            // sale.getProducts(),
            // sale.getClients()
        );
    }

    private Sale toEntity(SaleDTO dto) {
        return new Sale(
            dto.getId(),
            dto.getTotalPrice(),
            dto.getDiscount(),
            dto.getItemsQuantity(),
            dto.getPayment()
            // dto.getProducts(),
            // dto.getClients()
        );
    }
}
