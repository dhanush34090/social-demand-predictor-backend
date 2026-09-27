package com.sih.socialdemand.service;

import com.sih.socialdemand.dto.MLPredictionRequest;
import com.sih.socialdemand.dto.MLPredictionResponse;

public interface MLService {

    MLPredictionResponse predict(MLPredictionRequest request);

}