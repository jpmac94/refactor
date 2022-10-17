package com.refactor.project.service;

import com.refactor.project.model.GenericEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericService<T extends GenericEntity<Integer>,R extends JpaRepository<T,Integer>> {


    @Autowired
    protected R dto;

    public T create(T object) {
        return dto.save(object);
    }
    public T update(T object) throws Exception{
        dto.findById(object.getId()).orElseThrow(()->new Exception("not found"));
        return dto.save(object);
    }
    public void delete(Integer id){
        dto.deleteById(id);
    }
    public T findById(Integer id) throws Exception{
        return dto.findById(id).orElseThrow(()->new Exception("not foound"));
    }
    public List<T> list(){
        return dto.findAll();
    }
}
