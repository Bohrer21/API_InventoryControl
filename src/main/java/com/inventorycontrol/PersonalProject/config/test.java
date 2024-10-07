package com.inventorycontrol.PersonalProject.config;

import com.inventorycontrol.PersonalProject.dto.ClientDTO;
import com.inventorycontrol.PersonalProject.dto.ProductDTO;
import com.inventorycontrol.PersonalProject.entities.Stock;
import com.inventorycontrol.PersonalProject.entities.Client;
import com.inventorycontrol.PersonalProject.entities.Order;
import com.inventorycontrol.PersonalProject.dto.OrderItemDTO;
import com.inventorycontrol.PersonalProject.entities.Product;
import com.inventorycontrol.PersonalProject.repository.ClientRepository;
import com.inventorycontrol.PersonalProject.repository.OrderRepository;
import com.inventorycontrol.PersonalProject.repository.ProductRepository;
import com.inventorycontrol.PersonalProject.repository.StockRepository;
import com.inventorycontrol.PersonalProject.service.ProductService;

import com.inventorycontrol.PersonalProject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class test implements CommandLineRunner {

    @Autowired
    private ClientRepository clt;

    @Autowired
    private OrderRepository odr;

    @Autowired
    private ProductRepository pdr;

    @Autowired
    private StockRepository stk;

    @Autowired
    private StockService service;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        clt.deleteAll();
        odr.deleteAll();
        pdr.deleteAll();
        stk.deleteAll();

        Client maria = new Client(null, "Maria Brown", "maria@gmail.com", "(00)00000-0000");
        Client lucas = new Client(null, "Lucas Bohrer", "lucas@gmail.com", "(00)00000-0000");
        Client ronaldo = new Client(null, "Ronaldo Corbo", "ronaldo@gmail.com", "(00)00000-0000");
        Client rosiane = new Client(null, "Rosiane Bohrer", "rosiane@gmail.com", "(00)00000-0000");

        clt.saveAll(Arrays.asList(maria, lucas, ronaldo, rosiane));

        Product pdr1 = new Product(null, "Camisa", 50.29);
        Product pdr2 = new Product(null, "Bermuda", 84.90);

        pdr.saveAll(Arrays.asList(pdr1, pdr2));

        ProductDTO pdr01 = new ProductDTO(pdr1);
        ProductDTO pdr02 = new ProductDTO(pdr2);

        Stock stkCamisa = new Stock(null, 10, pdr01);
        Stock stkBermuda = new Stock(null, 7, pdr02);

        stk.saveAll(Arrays.asList(stkCamisa, stkBermuda));

        OrderItemDTO odr1 = new OrderItemDTO(stkCamisa.getId(), 2, pdr1.getPrice(), pdr01);
        OrderItemDTO odr2 = new OrderItemDTO(stkBermuda.getId(), 1, pdr2.getPrice(), pdr02);

        Order order1 = new Order(null, sdf.parse("02/07/2024"), new ClientDTO(lucas));

        order1.getItems().addAll(Arrays.asList(odr1, odr2));

        odr.save(order1);

        service.up(order1);

    }
}
