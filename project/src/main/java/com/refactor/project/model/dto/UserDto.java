package com.refactor.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String nombre;

    public UserDto(){}
}
