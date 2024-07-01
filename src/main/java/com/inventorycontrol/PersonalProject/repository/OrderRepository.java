package com.inventorycontrol.PersonalProject.repository;

import com.inventorycontrol.PersonalProject.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
