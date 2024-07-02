package com.inventorycontrol.PersonalProject.dto;

import com.inventorycontrol.PersonalProject.entities.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private String name;
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client clt) {
        name = clt.getName();
        email = clt.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
