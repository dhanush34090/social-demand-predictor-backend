package com.sih.socialdemand.service;

import com.sih.socialdemand.entity.Prediction;
import java.util.List;

public interface PredictionService {
    List<Prediction> getAll();
    List<Prediction> getByProduct(Long productId);
}
