package com.spring.manager.controller;

import com.spring.manager.dto.ProductDTO;
import com.spring.manager.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/manager/products")
public class ProductController {
    
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO productCreated = service.create(productDTO);
        return ResponseEntity.created(URI.create("/product/" + productCreated.getId())).body(productCreated);
    }

    // Read All
    @GetMapping("/readAll")
    public List<ProductDTO> listAll() {
        return service.listAll();
    }

    // Read By Id
    @GetMapping("/readById/{id}")
    public ResponseEntity<ProductDTO> listById(@PathVariable long id) {
        return ResponseEntity.ok(service.listById(id));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        ProductDTO productUpdated = service.update(id, productDTO);
        return productUpdated != null ? ResponseEntity.ok(productUpdated) : ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
