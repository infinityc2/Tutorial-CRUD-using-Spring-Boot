package com.example.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.example.project.entity.Basket;
import com.example.project.entity.Menu;
import com.example.project.entity.OrderMenu;
import com.example.project.repository.BasketRepository;
import com.example.project.repository.MenuRepository;
import com.example.project.repository.OrderMenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired private BasketRepository basketRepository;
    @Autowired private MenuRepository menuRepository;
    @Autowired private OrderMenuRepository orderMenuRepository;

    @GetMapping
    public List<Basket> getAllBasket() {
        return basketRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Basket> getBasket(@PathVariable Long id) {
        return basketRepository.findById(id);
    }

    @PostMapping("/progress")
    public OrderMenu newBasket(@RequestBody Map<String, Object> entity) {
        Basket newBasket = new Basket();
        OrderMenu order = new OrderMenu();
        Optional<Menu> menu = menuRepository.findById(Long.valueOf(entity.get("id").toString()));
        newBasket.setTotalprice(Long.valueOf(entity.get("totalprice").toString()));
        basketRepository.save(newBasket);
        order.setBasket(newBasket);
        order.setQuality(Integer.valueOf(entity.get("quality").toString()));
        order.setMenu(menu.get());
        return orderMenuRepository.save(order);
    }
    
    

}