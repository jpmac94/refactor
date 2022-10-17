package com.refactor.project.controller;


import com.refactor.project.mapper.UserMapper;
import com.refactor.project.model.GenericEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController <T extends GenericEntity<Integer>,R extends JpaRepository<T,Integer>,DTO> {

    @Autowired
    private UserMapper<T,R,DTO> mapper;

    @PostMapping("/create")
    public ResponseEntity<DTO> create(@RequestBody DTO object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.create(object));
    }
    @PutMapping("/update")
    public ResponseEntity<DTO> update(@RequestBody DTO object) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.update(object));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Integer id){
        mapper.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<DTO> findById(@PathVariable Integer id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(mapper.findById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<DTO>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(mapper.list());
    }

}
