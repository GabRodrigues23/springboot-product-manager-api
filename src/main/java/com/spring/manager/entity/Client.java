package com.spring.manager.entity;

import java.util.List;
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

    @ManyToMany(mappedBy = "clients")
    private List<Sale> sales;

    public Client(long id, String name, String cpf, String cep, String phone, List<Sale> sales) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.cep = cep;
        this.phone = phone;
        this.sales = sales;
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

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
