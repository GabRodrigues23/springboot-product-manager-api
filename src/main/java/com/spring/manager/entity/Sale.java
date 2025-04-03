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
    private BigDecimal totalPrice;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discount;
    
    @Column(nullable = false)
    private int itemsQuantity;

    @Column(nullable = false, length = 2)
    private String payment;
    
    // @ManyToMany()
    // @JoinTable(name = "SALE_PRODUCT", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    // private List<Product> products;

    // @ManyToMany()
    // @JoinTable(name = "SALE_CLIENT", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    // private List<Product> clients;

    public Sale() {
    }

    public Sale(long id, BigDecimal totalPrice, BigDecimal discount, int itemsQuantity, String payment /*, List<Product> products, List<Product> clients*/) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.itemsQuantity = itemsQuantity;
        this.payment = payment;
        // this.products = products;
        // this.clients = clients;
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

    public void setTotalPrice(BigDecimal totalPrice) {
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

    // public List<Product> getProducts() {
    //     return products;
    // }

    // public void setProducts(List<Product> products) {
    //     this.products = products;
    // }

    // public List<Product> getClients() {
    //     return clients;
    // }

    // public void setClients(List<Product> clients) {
    //     this.clients = clients;
    // }
}
