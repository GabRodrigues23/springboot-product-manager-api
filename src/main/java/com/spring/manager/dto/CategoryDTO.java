package com.spring.manager.dto;

import java.util.List;
import com.spring.manager.entity.Product;

public class CategoryDTO {
    private long id;
    private String name;
    private List<Product> products;
    
    public CategoryDTO() {
    }

    public CategoryDTO(long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
