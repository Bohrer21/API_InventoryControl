package com.inventorycontrol.PersonalProject.service;


import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
import com.inventorycontrol.PersonalProject.entities.Order;
import com.inventorycontrol.PersonalProject.entities.Product;
import com.inventorycontrol.PersonalProject.entities.Stock;
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

    public Stock update(Stock stk){
        Stock newStk = findById(stk.getId());
        updateStock(newStk, stk);
        return repository.save(newStk);
    }

    public void up(Order odr){

        for(OrderItemDTO item: odr.getItems()){
            Stock stk = findById(item.getIdStock());

            if(stk.getQuantity() >= item.getQuantity()){
                stk.setQuantity(stk.getQuantity() - item.getQuantity());

            } else{
                new ObjectNotFoundException("Não tem quantidade suficiente");
            }
            repository.save(stk);
        }
    }

    private void updateStock(Stock newStk, Stock stk){
        newStk.setQuantity(stk.getQuantity());
    }

}
