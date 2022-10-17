package com.refactor.project.mapper;



import com.fasterxml.jackson.core.type.TypeReference;
import com.refactor.project.model.GenericEntity;

import com.refactor.project.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper<T extends GenericEntity<Integer>,R extends JpaRepository<T,Integer>,DTO> {


    @Autowired
    protected GenericService<T,R> service;

    @Autowired
    protected Mapper mapper;

    public DTO create(DTO object) {
        return mapper.mapDtoEntity(new TypeReference<DTO>(){},service.create(mapper.mapDtoEntity(new TypeReference<T>(){},object)));
    }
    public DTO update(DTO object) throws Exception{
        return mapper.mapDtoEntity(new TypeReference<DTO>(){},service.update(mapper.mapDtoEntity(new TypeReference<T>(){},object)));
    }
    public void delete(Integer id){
       service.delete(id);
    }
    public DTO findById(Integer id) throws Exception{
        return mapper.mapDtoEntity(new TypeReference<DTO>(){},service.findById(id));
    }
    public List<DTO> list(){
        return  (List<DTO>) service.list().stream().map(item->mapper.mapDtoEntity(new TypeReference<DTO>(){},item)).collect(Collectors.toList());
    }






}
