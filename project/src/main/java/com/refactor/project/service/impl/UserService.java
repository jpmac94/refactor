package com.refactor.project.service.impl;

import com.refactor.project.model.entity.User;
import com.refactor.project.repository.UserRepository;
import com.refactor.project.service.GenericService;

public class UserService extends GenericService<User, UserRepository> {

    public User findByName(String name) throws Exception{
    return dto.findByName(name).orElseThrow(()->new Exception("not found"));
    }
}
