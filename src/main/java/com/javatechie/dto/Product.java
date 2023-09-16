package com.javatechie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String productType;



    public Product(String name, double price, String description, String productType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productType = productType;
    }

}
