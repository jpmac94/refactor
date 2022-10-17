package com.refactor.project.mapper;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private ObjectMapper objectMapper;


    public <T> T mapDtoEntity (TypeReference dto, Object object){
        objectMapper.registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        return (T) objectMapper.convertValue(object,dto);
    }

}
