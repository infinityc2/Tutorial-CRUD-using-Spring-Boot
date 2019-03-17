package com.example.project.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "basket")
@Entity
@NoArgsConstructor
@Data
public class Basket {

    @Id
    @GeneratedValue
    private Long id;

    private @NotNull Long totalprice;

    // @ManyToMany
    // @JoinTable(name = "menu_basket", joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "id"),
    // inverseJoinColumns = @JoinColumn(name = "manu_id", referencedColumnName = "id"))
    // private Set<Menu> menus;

}