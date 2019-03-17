package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.project.entity.Menu;
import com.example.project.repository.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired private MenuRepository menuRepository;

    @GetMapping
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Menu> getMenu(@PathVariable Long id) {
        return menuRepository.findById(id);
    }
    
    @PostMapping("/add/")
    public Menu newMenu(@RequestBody Map<String, Object> entity) {
        Menu newMenu = new Menu();
        newMenu.setName(entity.get("name").toString());
        newMenu.setPrice(Long.valueOf(entity.get("price").toString()));
        newMenu.setStock(Boolean.valueOf(entity.get("stock").toString()));
        return menuRepository.save(newMenu);
    }

    @PutMapping("/update/{id}")
    public Menu updateMenu(@RequestBody Menu entity) {
        try {
            return menuRepository.save(entity);
        } catch(Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMenu(@PathVariable Long id) {
        try {
            menuRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }  
    }
    
}