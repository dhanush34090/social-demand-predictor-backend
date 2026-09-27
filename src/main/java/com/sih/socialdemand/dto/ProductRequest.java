package com.sih.socialdemand.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
public class ProductRequest {
 @NotBlank private String name; private String category; @NotNull @PositiveOrZero private Double price; private String description;
 public ProductRequest(){} public String getName(){return name;} public void setName(String v){name=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public Double getPrice(){return price;} public void setPrice(Double v){price=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
}
