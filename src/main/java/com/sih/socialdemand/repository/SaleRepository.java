package com.sih.socialdemand.repository;

import com.sih.socialdemand.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByProductIdOrderBySaleDateDesc(Long productId);
}
