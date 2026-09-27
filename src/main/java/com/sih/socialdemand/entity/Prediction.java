package com.sih.socialdemand.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "predictions")
public class Prediction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "product_id")
    private Product product;
    private LocalDate predictionDate;
    private Double predictedDemand;
    private Double confidence;
    private String recommendation;

    public Prediction() {}
    public Prediction(Long id, Product product, LocalDate predictionDate, Double predictedDemand, Double confidence, String recommendation) {this.id=id;this.product=product;this.predictionDate=predictionDate;this.predictedDemand=predictedDemand;this.confidence=confidence;this.recommendation=recommendation;}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
    public LocalDate getPredictionDate(){return predictionDate;} public void setPredictionDate(LocalDate v){predictionDate=v;}
    public Double getPredictedDemand(){return predictedDemand;} public void setPredictedDemand(Double v){predictedDemand=v;}
    public Double getConfidence(){return confidence;} public void setConfidence(Double v){confidence=v;}
    public String getRecommendation(){return recommendation;} public void setRecommendation(String v){recommendation=v;}
}
