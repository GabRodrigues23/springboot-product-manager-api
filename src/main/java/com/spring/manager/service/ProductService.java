package com.spring.manager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.manager.dto.ProductDTO;
import com.spring.manager.entity.Product;
import com.spring.manager.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    // Create
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product(
            productDTO.getId(),
            productDTO.getBarcode(),
            productDTO.getDescription(),
            productDTO.getUnit(),
            productDTO.getPrice(),
            productDTO.getStock()
        );        
        
        Product newProduct = repository.save(product);

        return new ProductDTO(
            newProduct.getId(),
            newProduct.getBarcode(),
            newProduct.getDescription(),
            newProduct.getUnit(),
            newProduct.getPrice(),
            newProduct.getStock()
        );
    }

    // Read (Select)
    public List<ProductDTO> listAll() {
        return repository.findAll().stream()
            .map(product -> new ProductDTO(
                product.getId(), 
                product.getBarcode(), 
                product.getDescription(), 
                product.getUnit(), 
                product.getPrice(), 
                product.getStock()))
            .collect(Collectors.toList()
            );
    }

    public ProductDTO listById(long id) {
        Optional<Product> optionalProduct = repository.findById(id);
    
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return new ProductDTO(
                product.getId(), 
                product.getBarcode(), 
                product.getDescription(), 
                product.getUnit(), 
                product.getPrice(), 
                product.getStock()
            );
        }
        
        return null; // Later, replace with a custom exception
    }

    // Update
    public ProductDTO update(long id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = repository.findById(id);
    
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setBarcode(productDTO.getBarcode());
            product.setDescription(productDTO.getDescription());
            product.setUnit(productDTO.getUnit());
            product.setPrice(productDTO.getPrice());
            product.setStock(productDTO.getStock());
    
            Product updatedProduct = repository.save(product);
    
            return new ProductDTO(
                updatedProduct.getId(), 
                updatedProduct.getBarcode(), 
                updatedProduct.getDescription(), 
                updatedProduct.getUnit(), 
                updatedProduct.getPrice(), 
                updatedProduct.getStock()
            );
        }
    
        return null; // Later, replace with a custom exception
    }
    
    // Delete
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            return; // Replace with an exception later
        }
        repository.deleteById(id);
    }

}