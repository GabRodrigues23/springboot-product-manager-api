package com.spring.manager.controller;

import com.spring.manager.dto.CategoryDTO;
import com.spring.manager.service.CategoryService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/manager/categories")
public class CategoryController {
    
    private final CategoryService service;
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryCreated = service.create(categoryDTO);
        return ResponseEntity.created(URI.create("/category/" + categoryCreated.getId())).body(categoryCreated);
    }

    // Read All
    @GetMapping("/readAll")
    public List<CategoryDTO> listAll() {
        return service.listAll();
    }

    // Read By Id
    @GetMapping("/readById/{id}")
    public ResponseEntity<CategoryDTO> listById(@PathVariable long id) {
        return ResponseEntity.ok(service.listById(id));
    }

    // Update
    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryUpdated = service.update(id, categoryDTO);
        return categoryUpdated != null ? ResponseEntity.ok(categoryUpdated) : ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.notFound().build();
    }
}
