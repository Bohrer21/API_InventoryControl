package com.inventorycontrol.PersonalProject.dto;

import com.inventorycontrol.PersonalProject.entities.Product;
import com.inventorycontrol.PersonalProject.entities.Stock;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private String name;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Product pdr) {
        name = pdr.getName();
        price = pdr.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
