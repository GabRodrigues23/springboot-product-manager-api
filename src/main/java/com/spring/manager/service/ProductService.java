package com.spring.manager.service;

import org.springframework.stereotype.Service;

import com.spring.manager.dto.ProductDTO;
import com.spring.manager.entity.Product;
import com.spring.manager.repository.ProductRepository;

import java.util.List;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
    
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Create
    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product product = toEntity(productDTO);
        Product savedProduct = repository.save(product);
        return toDTO(savedProduct);
    }

    // Read (List All)
    public List<ProductDTO> listAll() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    // Read (By ID)
    public ProductDTO listById(long id) {
        return repository.findById(id)
            .map(this::toDTO)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update
    @Transactional
    public ProductDTO update(long id, ProductDTO productDTO) {
        Product product = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setBarcode(productDTO.getBarcode());
        product.setDescription(productDTO.getDescription());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());

        return toDTO(repository.save(product));
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
    private ProductDTO toDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getBarcode(),
            product.getDescription(),
            product.getUnit(),
            product.getPrice(),
            product.getStock()
        );
    }

    private Product toEntity(ProductDTO dto) {
        return new Product(
            dto.getId(),
            dto.getBarcode(),
            dto.getDescription(),
            dto.getUnit(),
            dto.getPrice(),
            dto.getStock()
        );
    }
}