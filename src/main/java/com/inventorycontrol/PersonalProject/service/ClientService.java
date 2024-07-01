package com.inventorycontrol.PersonalProject.service;

import com.inventorycontrol.PersonalProject.entities.Client;
import com.inventorycontrol.PersonalProject.repository.ClientRepository;
import com.inventorycontrol.PersonalProject.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(String id){
        Optional<Client> clt = repository.findById(id);
        return clt.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void insert(Client clt){
        repository.insert(clt);
    }

    public Client update(Client clt){
        Client newClt = findById(clt.getId());
        updateClient(newClt, clt);
        return repository.save(newClt);
    }

    private void updateClient(Client newClt, Client clt){
        newClt.setName(clt.getName());
        newClt.setEmail(clt.getEmail());
        newClt.setPhone(clt.getPhone());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
}
