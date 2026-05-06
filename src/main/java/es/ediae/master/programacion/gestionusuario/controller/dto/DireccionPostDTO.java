package es.ediae.master.programacion.gestionusuario.controller.dto;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import jakarta.validation.constraints.NotBlank;

public class DireccionPostDTO {
    private Integer id;
    
    @NotBlank(message = "El nombre de la calle es obligatorio")
    private String nombreCalle;
    private Integer numeroCalle;
    private Boolean direccionPrincipal;
    private UsuarioEntity usuario;

    // --- Constructores ---
    public DireccionPostDTO() {

    }

    public DireccionPostDTO(String nombreCalle, Integer numeroCalle, Boolean direccionPrincipal,
            UsuarioEntity usuario) {
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.direccionPrincipal = direccionPrincipal;
        this.usuario = usuario;

    }

    // --- Getters y Setters ---
    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public Boolean getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(Boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

}

