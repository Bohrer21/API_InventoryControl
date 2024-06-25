package com.inventorycontrol.PersonalProject.controller;

import com.inventorycontrol.PersonalProject.entities.Client;
import com.inventorycontrol.PersonalProject.service.ClientService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
