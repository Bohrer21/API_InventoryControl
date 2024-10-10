package com.inventorycontrol.PersonalProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventorycontrol.PersonalProject.entities.Product;

import java.io.Serializable;


public class OrderItemDTO implements Serializable {

    private String idStock;
    private int quantity;
    private double price;

    private ProductDTO product;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String idStock, int quantity, double price, ProductDTO product) {
        this.idStock = idStock;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public double getSubTotal(){
        return price * quantity;
    }
}
