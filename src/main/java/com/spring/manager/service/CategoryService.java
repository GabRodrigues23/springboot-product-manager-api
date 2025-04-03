package com.spring.manager.service;

import org.springframework.stereotype.Service;

import com.spring.manager.dto.CategoryDTO;
import com.spring.manager.entity.Category;
import com.spring.manager.repository.CategoryRepository;

import java.util.List;
import jakarta.transaction.Transactional;

@Service
public class CategoryService {
    
    private final CategoryRepository repository;
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    // Create
    @Transactional
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = toEntity(categoryDTO);
        Category savedCategory = repository.save(category);
        return toDTO(savedCategory);
    }

    // Read (List All)
    public List<CategoryDTO> listAll() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    // Read (By Id)
    public CategoryDTO listById(long id) {
        return repository.findById(id)
            .map(this::toDTO)
            .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Update
    @Transactional
    public CategoryDTO update(long id, CategoryDTO categoryDTO) {
        Category category = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDTO.getName());
        // category.setProducts(categoryDTO.getProducts());

        return toDTO(repository.save(category));
    }

    // Delete
    @Transactional
    public void delete(long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        repository.deleteById(id);
    }

    // Utilitary
    private CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
            category.getId(), 
            category.getName()
            // category.getProducts()
        );
    } 

    private Category toEntity(CategoryDTO dto) {
        return new Category(
            dto.getId(),
            dto.getName()
            // dto.getProducts()
        );
    }
}
