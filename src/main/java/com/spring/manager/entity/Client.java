package com.spring.manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(length = 14)
    private String cpf;

    @Column(length = 10) 
    private String cep;
    
    @Column(length = 15)
    private String phone;

    @ManyToMany()
    @JoinColumn(name = "sale_id")
    private Sale sale;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
