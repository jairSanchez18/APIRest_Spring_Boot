package com.spring.boot.firstspringbootproject.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.firstspringbootproject.models.UsuarioModel;
import com.spring.boot.firstspringbootproject.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> ObtenerUsuarios(){
        return usuarioService.ObtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel AgregarUsuarios(@RequestBody UsuarioModel usuario){
        return usuarioService.AgregarUsuarios(usuario);
    }

    @GetMapping(value = "/{id}")
    public Optional<UsuarioModel> BuscarUsuario(@PathVariable(value = "id") Long id){
        return usuarioService.BuscarUsuario(id);   
    }

    @DeleteMapping(value = "/{id}")
    public String BorrarUsuario(@PathVariable(value = "id") Long id){
        boolean ok = usuarioService.BorrarUsuario(id);

        if(ok){
            return "Borrado exitosamente";
        }else{
            return "usuario no encontrado";
        }
    }
}
