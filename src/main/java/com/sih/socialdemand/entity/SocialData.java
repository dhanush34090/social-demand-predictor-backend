package com.sih.socialdemand.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Table(name = "social_data")
public class SocialData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "product_id")
    private Product product;
    private String platform;
    @Column(length = 2000) private String content;
    @PositiveOrZero private Integer likes;
    @PositiveOrZero private Integer comments;
    @PositiveOrZero private Integer shares;
    @PositiveOrZero private Integer mentions;
    private Double sentimentScore;
    private Double trendScore;
    @NotNull private LocalDate dataDate;

    public SocialData() {}
    public SocialData(Long id, Product product, String platform, String content, Integer likes, Integer comments, Integer shares, Integer mentions, Double sentimentScore, Double trendScore, LocalDate dataDate) { this.id=id;this.product=product;this.platform=platform;this.content=content;this.likes=likes;this.comments=comments;this.shares=shares;this.mentions=mentions;this.sentimentScore=sentimentScore;this.trendScore=trendScore;this.dataDate=dataDate; }
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
    public String getPlatform(){return platform;} public void setPlatform(String v){platform=v;}
    public String getContent(){return content;} public void setContent(String v){content=v;}
    public Integer getLikes(){return likes;} public void setLikes(Integer v){likes=v;}
    public Integer getComments(){return comments;} public void setComments(Integer v){comments=v;}
    public Integer getShares(){return shares;} public void setShares(Integer v){shares=v;}
    public Integer getMentions(){return mentions;} public void setMentions(Integer v){mentions=v;}
    public Double getSentimentScore(){return sentimentScore;} public void setSentimentScore(Double v){sentimentScore=v;}
    public Double getTrendScore(){return trendScore;} public void setTrendScore(Double v){trendScore=v;}
    public LocalDate getDataDate(){return dataDate;} public void setDataDate(LocalDate v){dataDate=v;}
}
