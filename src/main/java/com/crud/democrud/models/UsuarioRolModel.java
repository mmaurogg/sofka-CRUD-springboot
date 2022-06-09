package com.crud.democrud.models;

import javax.persistence.*;

@Entity 
@Table(name = "rol")
public class UsuarioRolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    private String rol;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private UsuarioModel usuario;

    private final String[] arrRoles = {"vendedor","cajero","supervisor","conductor","consultor"};

    public UsuarioRolModel() {
    }

    public UsuarioRolModel(Long idUsuario, String rol) {
        this.idUsuario = idUsuario;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        // for (String category : arrRoles) {
        //     if(rol.equalsIgnoreCase(category)){
        //         this.rol = rol;
        //     } else {
        //     this.rol = null;
        //     }
        // }
        this.rol = rol;
    }

}
