package com.refactor.project.model.entity;

import com.refactor.project.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User extends GenericEntity<Integer> {
    private String nombre;
    private Integer code;
    public User(){}
}
