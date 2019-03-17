package com.example.project.dataloader;

import com.example.project.entity.Menu;
import com.example.project.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuDataloader implements ApplicationRunner {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        menuRepository.save(new Menu("Espresso", 45L, true));
        menuRepository.save(new Menu("Amazon", 50L, true));
        menuRepository.save(new Menu("Amazon Extra", 55L, true));
        menuRepository.save(new Menu("Black Coffee", 45L, true));
        menuRepository.save(new Menu("Cappuccino", 50L, true));
        menuRepository.save(new Menu("Latte Amazon", 55L, true));
        menuRepository.save(new Menu("Macha", 45L, true));
        menuRepository.save(new Menu("White Choc Macchiato", 50L, true));
        menuRepository.save(new Menu("Iced Coffee Soya", 55L, true));

        menuRepository.findAll().forEach(System.out::println);
    }


}