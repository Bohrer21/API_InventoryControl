package com.inventorycontrol.PersonalProject.entities;

import com.inventorycontrol.PersonalProject.dto.ClientDTO;
import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
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

    private ClientDTO client;

    private List<OrderItemDTO> items = new ArrayList<>();

    public Order() {
    }

    public Order(String id, Date dateCreate, ClientDTO client) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.client = client;
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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public double getTotal(){
        double sum = 0;
        for(OrderItemDTO x : items) {
            sum += x.getSubTotal();
        }
        return sum;
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
