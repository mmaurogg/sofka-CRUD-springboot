package com.crud.democrud.ServicesTest;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.repositories.UsuarioRolRepositorio;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRolServiceTest {

    @Autowired
    UsuarioRolRepositorio usuarioRolRepositorio;

    // @Test
    // public void testGuardarUsuario(){
    //     UsuarioModel usuarioModel=new UsuarioModel("aquaman","aqua@gmail.com",99);
    //     UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
    //     assertNotNull(usuarioModelRegistrado);
    // }
    
    @Test
    public void testGuardarUsuarioRol(){
        UsuarioModel usuarioModel=new UsuarioModel("aquaman","aqua@gmail.com",99);
        UsuarioRolModel usuarioRolModel = new UsuarioRolModel(1L, "vengador");
        UsuarioRolModel usuarioRolModelRegistrado = usuarioRolRepositorio.save(usuarioRolModel); 
        assertNotNull(usuarioRolModelRegistrado);
    }

    @Test
    public void testBuscarUsuarioRolPorId(){
        Long idBuscado=1L;
        Optional<UsuarioRolModel> usuarioRolModelBuscado = usuarioRolRepositorio.findById(idBuscado);
        assertThat(usuarioRolModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarioRoles(){
        List<UsuarioRolModel> usuarioRolModelList=(List<UsuarioRolModel>) usuarioRolRepositorio.findAll();
        assertThat(usuarioRolModelList).size().isGreaterThan(0);
    }
}
