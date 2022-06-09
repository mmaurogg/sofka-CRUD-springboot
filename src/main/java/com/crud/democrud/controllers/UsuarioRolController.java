package com.crud.democrud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;

@RestController
@RequestMapping("/usuarioRol")
public class UsuarioRolController {
    
    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRolModel> obtenerUsuarios() {
        return usuarioRolService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioRolModel guardarUsuario(@RequestBody UsuarioRolModel usuario) {
        return this.usuarioRolService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioRolModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioRolService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioRolService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    @PostMapping(path = "/{id}")
    public String actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioRolModel usuarioRol) {
        boolean ok = this.usuarioRolService.actualizarUsuario(id, usuarioRol);
        if (ok) {
            return "Se actualizó el usuario con id " + id;
        } else {
            return "No pudo actualizar el usuario con id" + id;
        }
    }
}
