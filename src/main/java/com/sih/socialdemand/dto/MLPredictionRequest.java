package com.sih.socialdemand.dto;

public class MLPredictionRequest {

    private Long productId;
    private double price;
    private double likes;
    private double comments;
    private double shares;
    private double mentions;
    private double sentiment_score;
    private double trend_score;
    private double historical_sales;

    public MLPredictionRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLikes() {
        return likes;
    }

    public void setLikes(double likes) {
        this.likes = likes;
    }

    public double getComments() {
        return comments;
    }

    public void setComments(double comments) {
        this.comments = comments;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

    public double getMentions() {
        return mentions;
    }

    public void setMentions(double mentions) {
        this.mentions = mentions;
    }

    public double getSentiment_score() {
        return sentiment_score;
    }

    public void setSentiment_score(double sentiment_score) {
        this.sentiment_score = sentiment_score;
    }

    public double getTrend_score() {
        return trend_score;
    }

    public void setTrend_score(double trend_score) {
        this.trend_score = trend_score;
    }

    public double getHistorical_sales() {
        return historical_sales;
    }

    public void setHistorical_sales(double historical_sales) {
        this.historical_sales = historical_sales;
    }
}