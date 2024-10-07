package com.inventorycontrol.PersonalProject.repository;

import com.inventorycontrol.PersonalProject.entities.Client;
import com.inventorycontrol.PersonalProject.entities.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
}
