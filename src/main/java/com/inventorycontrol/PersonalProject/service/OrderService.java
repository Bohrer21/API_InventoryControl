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
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private StockRepository stockRepository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(String id){
        Optional<Order> odr = repository.findById(id);
        return odr.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void insert(Order odr){
        repository.insert(odr);
    }

    public void up(Order odr){

        for(OrderItemDTO item: odr.getItems()){
            Stock stk = stockRepository.findById(item.getIdStock()).orElseThrow(() -> new ObjectNotFoundException("Número do ID incorreto"));

            if(stk.getQuantity() >= item.getQuantity()){
                stk.setQuantity(stk.getQuantity() - item.getQuantity());

            } else{
                throw new ObjectNotFoundException("Quantidade insuficiente no estoque");
            }
            stockRepository.save(stk);
        }
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
}
