package com.example.project.repository;

import com.example.project.entity.OrderMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long>{

    
}