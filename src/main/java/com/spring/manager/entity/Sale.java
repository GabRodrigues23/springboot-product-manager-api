package com.spring.manager.entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "SALE")
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discount;
    
    @Column(nullable = false)
    private int items_quantity;

    @Column(nullable = false, length = 2)
    private String payment;
    
    @ManyToMany(mappedBy = "product")
    private List<Product> products;
    
    @ManyToMany(mappedBy = "client")
    private List<Client> clients;

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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
