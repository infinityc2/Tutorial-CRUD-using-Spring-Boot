package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "staff")
@Entity
@NoArgsConstructor
@Data
public class Staff {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    private @NotNull String username;
    private @NotNull String password;

    @ManyToOne
    private Position position;

}