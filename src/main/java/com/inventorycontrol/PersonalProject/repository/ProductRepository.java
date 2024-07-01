package com.inventorycontrol.PersonalProject.repository;

import com.inventorycontrol.PersonalProject.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
