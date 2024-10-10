package com.inventorycontrol.PersonalProject.controller;

import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
import com.inventorycontrol.PersonalProject.entities.Order;
import com.inventorycontrol.PersonalProject.entities.Stock;
import com.inventorycontrol.PersonalProject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/stocks")
public class StockController {

    @Autowired
    private StockService service;

    @GetMapping
    public ResponseEntity<List<Stock>> findAll(){
        List<Stock> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stock> findById(@PathVariable String id){
        Stock stk = service.findById(id);
        return ResponseEntity.ok().body(stk);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Stock stk){
        service.insert(stk);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stk.getId()).toUri();
        return ResponseEntity.noContent().build();
    }
}
