package com.sih.socialdemand.controller;

import com.sih.socialdemand.dto.MLPredictionRequest;
import com.sih.socialdemand.dto.MLPredictionResponse;
import com.sih.socialdemand.entity.Prediction;
import com.sih.socialdemand.service.MLService;
import com.sih.socialdemand.service.PredictionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predictions")
@CrossOrigin(origins = "*")
public class PredictionController {

    private final PredictionService service;
    private final MLService mlService;

    public PredictionController(
            PredictionService service,
            MLService mlService) {

        this.service = service;
        this.mlService = mlService;
    }

    @GetMapping
    public List<Prediction> getAll() {
        return service.getAll();
    }

    @GetMapping("/product/{productId}")
    public List<Prediction> getByProduct(
            @PathVariable Long productId) {

        return service.getByProduct(productId);
    }

    @PostMapping("/predict")
    public ResponseEntity<MLPredictionResponse> predict(
            @RequestBody MLPredictionRequest request) {

        MLPredictionResponse response =
                mlService.predict(request);

        return ResponseEntity.ok(response);
    }
}