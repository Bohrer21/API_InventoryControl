package com.inventorycontrol.PersonalProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
import com.inventorycontrol.PersonalProject.dto.ProductDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class Stock implements Serializable {

    @Id
    private String id;
    private int quantity;

    private ProductDTO product;

    public Stock() {
    }

    public Stock(String id, int quantity, ProductDTO product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
