package com.inventorycontrol.PersonalProject.repository;

import com.inventorycontrol.PersonalProject.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
}
