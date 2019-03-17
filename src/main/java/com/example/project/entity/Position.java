package com.example.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "position")
@Entity
@NoArgsConstructor
@Data
public class Position {

	@Id
    @GeneratedValue
    private Long id;

    private @NotNull String position;

    public Position(String position) {
        this.position = position;
	}
}