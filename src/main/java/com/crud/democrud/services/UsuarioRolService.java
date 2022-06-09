package com.crud.democrud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepositorio;

@Service
public class UsuarioRolService {
    
    @Autowired
    UsuarioRolRepositorio usuarioRolRepositorio;

    public ArrayList<UsuarioRolModel> obtenerUsuariosRoles(){
        return (ArrayList<UsuarioRolModel>) usuarioRolRepositorio.findAll();
    }

    public UsuarioRolModel guardarUsuarioRol(UsuarioRolModel usuarioRol){
        return usuarioRolRepositorio.save(usuarioRol);
    }

    public ArrayList<UsuarioRolModel> obtenerUsuarios(){
        return (ArrayList<UsuarioRolModel>) usuarioRolRepositorio.findAll();
    }

    public UsuarioRolModel guardarUsuario(UsuarioRolModel usuarioRol){
        return usuarioRolRepositorio.save(usuarioRol);
    }

    public Optional<UsuarioRolModel> obtenerPorId(Long id){
        return usuarioRolRepositorio.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRolRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean actualizarUsuario(long id, UsuarioRolModel usuarioRol){
        usuarioRol.setId(id);
        try{
            usuarioRolRepositorio.save(usuarioRol);
            return true;
        }catch(Exception err){
            return false;
        }
    }



}
