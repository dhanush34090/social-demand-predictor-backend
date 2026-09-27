package com.sih.socialdemand.service.impl;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sih.socialdemand.dto.MLPredictionRequest;
import com.sih.socialdemand.dto.MLPredictionResponse;
import com.sih.socialdemand.entity.Prediction;
import com.sih.socialdemand.entity.Product;
import com.sih.socialdemand.repository.PredictionRepository;
import com.sih.socialdemand.repository.ProductRepository;
import com.sih.socialdemand.service.MLService;

@Service
public class MLServiceImpl implements MLService {

    private final RestTemplate restTemplate;
    private final ProductRepository productRepository;
    private final PredictionRepository predictionRepository;

    private static final String ML_URL =
            "http://127.0.0.1:8000/api/ml/predict";

    public MLServiceImpl(
            RestTemplate restTemplate,
            ProductRepository productRepository,
            PredictionRepository predictionRepository) {

        this.restTemplate = restTemplate;
        this.productRepository = productRepository;
        this.predictionRepository = predictionRepository;
    }

    @Override
    public MLPredictionResponse predict(MLPredictionRequest request) {

        // 1. Send data to Python ML API
        ResponseEntity<MLPredictionResponse> response =
                restTemplate.postForEntity(
                        ML_URL,
                        request,
                        MLPredictionResponse.class
                );

        MLPredictionResponse result = response.getBody();

        if (result == null) {
            throw new RuntimeException("ML service returned empty response");
        }

        // 2. Find product from PostgreSQL
        Product product = productRepository
                .findById(request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found with ID: "
                                + request.getProductId()
                        )
                );

        // 3. Create Prediction entity
        Prediction prediction = new Prediction();

        prediction.setProduct(product);
        prediction.setPredictionDate(LocalDate.now());
        prediction.setPredictedDemand(result.getPredictedDemand());
        prediction.setConfidence(result.getConfidence());
        prediction.setRecommendation(result.getRecommendation());

        // 4. Save prediction to PostgreSQL
        predictionRepository.save(prediction);

        // 5. Return result to frontend/Postman
        result.setProductId(product.getId());

        return result;
    }
}