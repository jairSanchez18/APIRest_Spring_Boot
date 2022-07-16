package com.spring.boot.firstspringbootproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.firstspringbootproject.models.UsuarioModel;

@Repository
public interface UsuarioRepositories extends CrudRepository<UsuarioModel, Long>{
        
}
