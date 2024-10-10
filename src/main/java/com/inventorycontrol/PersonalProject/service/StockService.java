package com.inventorycontrol.PersonalProject.service;


import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
import com.inventorycontrol.PersonalProject.entities.Order;
import com.inventorycontrol.PersonalProject.entities.Product;
import com.inventorycontrol.PersonalProject.entities.Stock;
import com.inventorycontrol.PersonalProject.repository.OrderRepository;
import com.inventorycontrol.PersonalProject.repository.StockRepository;
import com.inventorycontrol.PersonalProject.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public List<Stock> findAll(){
        return repository.findAll();
    }

    public Stock findById(String id){
        Optional<Stock> stk = repository.findById(id);
        return stk.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void insert(Stock stk){
        repository.insert(stk);
    }
}
