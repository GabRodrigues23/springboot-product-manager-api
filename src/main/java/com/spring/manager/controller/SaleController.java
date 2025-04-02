package com.spring.manager.controller;

import com.spring.manager.dto.SaleDTO;
import com.spring.manager.service.SaleService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/manager/sales")
public class SaleController {
    
    private SaleService service;
    public SaleController(SaleService saleService) {
        this.service = service;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<SaleDTO> create(@Valid @RequestBody SaleDTO saleDTO) {
        SaleDTO saleCreated = service.create(saleDTO);
        return ResponseEntity.created(URI.create("/sale/" + saleCreated.getId())).body(saleCreated);
    }

    // Read All
    @GetMapping("/readAll")
    public List<SaleDTO> listAll() {
        return service.listAll();
    }

    // Read By Id
    @GetMapping("/readById/{id}")
    public ResponseEntity<SaleDTO> listById(@PathVariable long id) {
        return ResponseEntity.ok(service.listById(id));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<SaleDTO> update(@PathVariable long id, @RequestBody SaleDTO saleDTO) {
        SaleDTO saleUpdated = service.update(id, saleDTO);
        return saleUpdated != null ? ResponseEntity.ok(saleUpdated) : ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
