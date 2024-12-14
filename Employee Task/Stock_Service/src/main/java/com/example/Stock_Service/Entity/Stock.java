package com.example.Stock_Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Stock {

    @Id
    private Long id;
    private String category;
    private Double price;
    private  String dress_name;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDress_name() {
        return dress_name;
    }

    public void setDress_name(String dress_name) {
        this.dress_name = dress_name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    private Long quantity;

}

