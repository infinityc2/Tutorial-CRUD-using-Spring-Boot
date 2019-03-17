package com.example.project.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "menu")
@Entity
@NoArgsConstructor
@Data
public class Menu {

	@Id
    @GeneratedValue
    private Long id;

    private @NotNull String name;
    private @NotNull Long price;
    private @NotNull Boolean stock;

    // @ManyToMany(mappedBy = "menus")
    // @JsonBackReference
    // private Set<Basket> baskets;

    public Menu(String name, Long price, boolean stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
	}

    // @ManyToOne
    // @JoinColumn(name = "basketId")
    // private Basket basket;
}