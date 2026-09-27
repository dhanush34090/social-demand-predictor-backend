package com.sih.socialdemand.service.impl;

import com.sih.socialdemand.dto.SaleRequest;
import com.sih.socialdemand.entity.Product;
import com.sih.socialdemand.entity.Sale;
import com.sih.socialdemand.repository.ProductRepository;
import com.sih.socialdemand.repository.SaleRepository;
import com.sih.socialdemand.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Sale create(SaleRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantity(request.getQuantity());
        sale.setSaleDate(request.getSaleDate());
        sale.setRevenue(request.getRevenue());

        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> getByProduct(Long productId) {
        return saleRepository.findByProductIdOrderBySaleDateDesc(productId);
    }
}
