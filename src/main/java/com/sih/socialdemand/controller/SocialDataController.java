package com.sih.socialdemand.controller;

import com.sih.socialdemand.dto.SocialDataRequest;
import com.sih.socialdemand.entity.SocialData;
import com.sih.socialdemand.service.SocialDataService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-data")
@CrossOrigin(origins = "*")
public class SocialDataController {

    private final SocialDataService service;

    public SocialDataController(SocialDataService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SocialData create(@Valid @RequestBody SocialDataRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<SocialData> getAll() {
        return service.getAll();
    }

    @GetMapping("/product/{productId}")
    public List<SocialData> getByProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }
}
