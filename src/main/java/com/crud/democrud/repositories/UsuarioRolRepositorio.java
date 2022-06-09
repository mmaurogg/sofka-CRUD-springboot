package com.crud.democrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.democrud.models.UsuarioRolModel;

@Repository
public interface UsuarioRolRepositorio extends CrudRepository<UsuarioRolModel, Long> {


}
