package com.spring.manager.dto;

import java.math.BigDecimal;
import java.util.List;
import com.spring.manager.entity.Product;

public class SaleDTO {
    private long id;
    private BigDecimal total_price;
    private BigDecimal discount;
    private int items_quantity;
    private String payment;
    private List<Product> products;
    private List<Product> clients;
    
    public SaleDTO() {
    }

    public SaleDTO(long id, BigDecimal total_price, BigDecimal discount, int items_quantity, String payment,
            List<Product> products, List<Product> clients) {
        this.id = id;
        this.total_price = total_price;
        this.discount = discount;
        this.items_quantity = items_quantity;
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

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getItems_quantity() {
        return items_quantity;
    }

    public void setItems_quantity(int items_quantity) {
        this.items_quantity = items_quantity;
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
