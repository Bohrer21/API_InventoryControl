package com.inventorycontrol.PersonalProject.entities;

import com.inventorycontrol.PersonalProject.dto.ClientDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Order implements Serializable {

    @Id
    private String id;
    private Date dateCreate;
    private int quantity;
    private double price;

    private ClientDTO cltDTO;

    private List<Product> Products = new ArrayList<>();

    public Order() {
    }

    public Order(String id, Date dateCreate, int quantity, double price, ClientDTO cltDTO) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.quantity = quantity;
        this.price = price;
        this.cltDTO = cltDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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

    public ClientDTO getCltDTO() {
        return cltDTO;
    }

    public void setCltDTO(ClientDTO cltDTO) {
        this.cltDTO = cltDTO;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
