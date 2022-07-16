package com.spring.boot.firstspringbootproject.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.firstspringbootproject.models.UsuarioModel;
import com.spring.boot.firstspringbootproject.repositories.UsuarioRepositories;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositories usuarioRepositories;

    public ArrayList<UsuarioModel> ObtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositories.findAll();
    }

    public UsuarioModel AgregarUsuarios(@RequestBody UsuarioModel usuario){
        return usuarioRepositories.save(usuario);
    }

    public Optional<UsuarioModel> BuscarUsuario(Long id){
        return usuarioRepositories.findById(id);
    }

    public Boolean BorrarUsuario(Long id){
        try {
            usuarioRepositories.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
