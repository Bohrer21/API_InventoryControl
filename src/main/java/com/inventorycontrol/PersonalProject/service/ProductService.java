package com.inventorycontrol.PersonalProject.service;

import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
import com.inventorycontrol.PersonalProject.entities.Order;
import com.inventorycontrol.PersonalProject.entities.Product;
import com.inventorycontrol.PersonalProject.repository.ProductRepository;
import com.inventorycontrol.PersonalProject.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(String id){
        Optional<Product> pdr = repository.findById(id);
        return pdr.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void insert(Product pdr){
        repository.insert(pdr);
    }

    public Product update(Product pdr){
        Product newPdr = findById(pdr.getId());
        updateProduct(newPdr, pdr);
        return repository.save(newPdr);
    }

    private void updateProduct(Product newPdr, Product pdr){
        newPdr.setName(pdr.getName());
        newPdr.setPrice(pdr.getPrice());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
}
