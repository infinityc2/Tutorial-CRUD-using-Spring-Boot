package com.example.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.project.entity.Position;
import com.example.project.entity.Staff;
import com.example.project.repository.PositionRepository;
import com.example.project.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired private StaffRepository staffRepository;
    @Autowired private PositionRepository positionRepository;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaff(@PathVariable Long id) {
        return staffRepository.findById(id);
    }

    @PostMapping("/register")
    public Staff newStaff(@RequestBody Map<String, Object> entity) {
        Optional<Position> position = positionRepository.findById(Long.valueOf(entity.get("id").toString()));
        Staff newStaff = new Staff();
        newStaff.setUsername(entity.get("username").toString());
        newStaff.setPassword(entity.get("password").toString());
        newStaff.setPosition(position.get());
        return staffRepository.save(newStaff);
    }
    
    @PutMapping("/update/{id}")
    public Staff updateStaff(@RequestBody Staff entity) {
        try {
            return staffRepository.save(entity);
        } catch(Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStaff(@PathVariable Long id) {
        try {
            staffRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }  
    }
    
}