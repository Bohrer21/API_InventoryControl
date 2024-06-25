package com.inventorycontrol.PersonalProject.service;

import com.inventorycontrol.PersonalProject.entities.Client;
import com.inventorycontrol.PersonalProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }
}
