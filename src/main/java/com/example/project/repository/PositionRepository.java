package com.example.project.repository;

import com.example.project.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<Position, Long>{

    
}