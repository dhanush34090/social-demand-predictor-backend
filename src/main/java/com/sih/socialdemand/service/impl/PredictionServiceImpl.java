package com.sih.socialdemand.service.impl;

import com.sih.socialdemand.entity.Prediction;
import com.sih.socialdemand.repository.PredictionRepository;
import com.sih.socialdemand.service.PredictionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final PredictionRepository repository;

    public PredictionServiceImpl(PredictionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Prediction> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Prediction> getByProduct(Long productId) {
        return repository.findByProductIdOrderByPredictionDateDesc(productId);
    }
}
