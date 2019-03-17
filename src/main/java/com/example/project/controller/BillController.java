package com.example.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.project.entity.Basket;
import com.example.project.entity.Bill;
import com.example.project.entity.Menu;
import com.example.project.entity.Staff;
import com.example.project.repository.BasketRepository;
import com.example.project.repository.BillRepository;
import com.example.project.repository.MenuRepository;
import com.example.project.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired private BillRepository billRepository;
    @Autowired private BasketRepository basketRepository;
    @Autowired private StaffRepository staffRepository;

    @GetMapping
    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bill> getBill(@PathVariable Long id) {
        return billRepository.findById(id);
    }

    @PostMapping("/purchased")
    public Bill addBill(@RequestBody Map<String, Object> entity) {
        Bill newBill = new Bill();
        Optional<Staff> staff = staffRepository.findById(Long.valueOf(entity.get("id").toString()));
        Optional<Basket> basket = basketRepository.findById(Long.valueOf(entity.get("id").toString()));
        newBill.setStaff(staff.get());
        newBill.setBasket(basket.get());
        return billRepository.save(newBill);
    }
    
    
    
}