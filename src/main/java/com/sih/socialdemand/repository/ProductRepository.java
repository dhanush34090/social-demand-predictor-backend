package com.sih.socialdemand.repository;

import com.sih.socialdemand.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
