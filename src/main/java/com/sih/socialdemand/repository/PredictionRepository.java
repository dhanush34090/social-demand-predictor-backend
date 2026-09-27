package com.sih.socialdemand.repository;

import com.sih.socialdemand.entity.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
    List<Prediction> findByProductIdOrderByPredictionDateDesc(Long productId);
}
