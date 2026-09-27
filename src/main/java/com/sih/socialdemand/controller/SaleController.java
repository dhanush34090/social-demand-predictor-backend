package com.sih.socialdemand.controller;

import com.sih.socialdemand.dto.SaleRequest;
import com.sih.socialdemand.entity.Sale;
import com.sih.socialdemand.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale create(@Valid @RequestBody SaleRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Sale> getAll() {
        return service.getAll();
    }

    @GetMapping("/product/{productId}")
    public List<Sale> getByProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }
}
