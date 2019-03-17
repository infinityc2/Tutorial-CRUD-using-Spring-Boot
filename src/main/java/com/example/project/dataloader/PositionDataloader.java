package com.example.project.dataloader;

import java.util.stream.Stream;

import com.example.project.entity.Position;
import com.example.project.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PositionDataloader implements ApplicationRunner {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("ADMIN", "EMPLOYEE").forEach(staff -> {
            positionRepository.save(new Position(staff));
        });

        positionRepository.findAll().forEach(System.out::println);
    }


}