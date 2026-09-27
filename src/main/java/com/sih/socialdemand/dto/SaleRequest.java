package com.sih.socialdemand.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
public class SaleRequest {
 @NotNull private Long productId; @NotNull @PositiveOrZero private Integer quantity; @NotNull private LocalDate saleDate; @NotNull @PositiveOrZero private Double revenue;
 public SaleRequest(){} public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;} public Integer getQuantity(){return quantity;} public void setQuantity(Integer v){quantity=v;} public LocalDate getSaleDate(){return saleDate;} public void setSaleDate(LocalDate v){saleDate=v;} public Double getRevenue(){return revenue;} public void setRevenue(Double v){revenue=v;}
}
