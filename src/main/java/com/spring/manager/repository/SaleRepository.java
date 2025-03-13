package com.spring.manager.repository;

import com.spring.manager.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    
}
