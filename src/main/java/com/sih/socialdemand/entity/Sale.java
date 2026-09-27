package com.sih.socialdemand.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "product_id")
    private Product product;
    @NotNull @PositiveOrZero private Integer quantity;
    @NotNull private LocalDate saleDate;
    @NotNull @PositiveOrZero private Double revenue;

    public Sale() {}
    public Sale(Long id, Product product, Integer quantity, LocalDate saleDate, Double revenue) { this.id=id; this.product=product; this.quantity=quantity; this.saleDate=saleDate; this.revenue=revenue; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
    public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
    public LocalDate getSaleDate(){return saleDate;} public void setSaleDate(LocalDate saleDate){this.saleDate=saleDate;}
    public Double getRevenue(){return revenue;} public void setRevenue(Double revenue){this.revenue=revenue;}
}
