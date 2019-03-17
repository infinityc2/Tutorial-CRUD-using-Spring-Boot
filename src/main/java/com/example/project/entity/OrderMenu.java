package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order_menu")
@Entity
@Data
@NoArgsConstructor
public class OrderMenu {

    @Id
    @GeneratedValue
    private Long id;

    private int quality;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "basketId")
    private Basket basket;

    public OrderMenu(int quality, Menu menu, Basket basket) {
        this.quality = quality;
        this.menu = menu;
        this.basket = basket;
    }
}