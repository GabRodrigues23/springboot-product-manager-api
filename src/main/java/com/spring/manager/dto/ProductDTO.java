package com.spring.manager.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private long id;
    private String barcode;
    private String description;
    private Character unit;
    private BigDecimal price;
    private long stock;

    public ProductDTO() {     
    }

    public ProductDTO(long id, String barcode, String description, Character unit, BigDecimal price, long stock) {
        this.id = id;
        this.barcode = barcode;
        this.description = description;
        this.unit = unit;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getUnit() {
        return unit;
    }

    public void setUnit(Character unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    
    
}
