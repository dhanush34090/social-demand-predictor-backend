package com.sih.socialdemand.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
public class SocialDataRequest {
 @NotNull private Long productId; private String platform; private String content; @PositiveOrZero private Integer likes; @PositiveOrZero private Integer comments; @PositiveOrZero private Integer shares; @PositiveOrZero private Integer mentions; private Double sentimentScore; private Double trendScore; @NotNull private LocalDate dataDate;
 public SocialDataRequest(){} public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;} public String getPlatform(){return platform;} public void setPlatform(String v){platform=v;} public String getContent(){return content;} public void setContent(String v){content=v;} public Integer getLikes(){return likes;} public void setLikes(Integer v){likes=v;} public Integer getComments(){return comments;} public void setComments(Integer v){comments=v;} public Integer getShares(){return shares;} public void setShares(Integer v){shares=v;} public Integer getMentions(){return mentions;} public void setMentions(Integer v){mentions=v;} public Double getSentimentScore(){return sentimentScore;} public void setSentimentScore(Double v){sentimentScore=v;} public Double getTrendScore(){return trendScore;} public void setTrendScore(Double v){trendScore=v;} public LocalDate getDataDate(){return dataDate;} public void setDataDate(LocalDate v){dataDate=v;}
}
