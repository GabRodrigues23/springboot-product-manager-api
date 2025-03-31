package com.spring.manager.dto;

import java.math.BigDecimal;
import java.util.List;
import com.spring.manager.entity.Product;

public class SaleDTO {
    private long id;
    private BigDecimal totalPrice;
    private BigDecimal discount;
    private int itemsQuantity;
    private String payment;
    private List<Product> products;
    private List<Product> clients;
    
    public SaleDTO() {
    }

    public SaleDTO(long id, BigDecimal totalPrice, BigDecimal discount, int itemsQuantity, String payment,
            List<Product> products, List<Product> clients) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.itemsQuantity = itemsQuantity;
        this.payment = payment;
        this.products = products;
        this.clients = clients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotal_price(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(int itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getClients() {
        return clients;
    }

    public void setClients(List<Product> clients) {
        this.clients = clients;
    }
}
