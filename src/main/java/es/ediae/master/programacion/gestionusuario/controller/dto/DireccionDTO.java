package es.ediae.master.programacion.gestionusuario.controller.dto;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import jakarta.validation.constraints.NotBlank;

public class DireccionDTO {
    private Integer id;
    @NotBlank(message = "El nombre de la calle es obligatorio")
    private String nombreCalle;
    private Integer numeroCalle;
    private Boolean direccionPrincipal;
    private UsuarioEntity usuario;

    // --- Constructores ---
    public DireccionDTO() {

    }

    public DireccionDTO(Integer id, String nombreCalle, Integer numeroCalle, Boolean direccionPrincipal, UsuarioEntity usuario) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.direccionPrincipal = direccionPrincipal;
        this.usuario = usuario;


    }


    // --- Getters y Setters ---
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

      public static DireccionDTO fromModel(DireccionModel direccionModel) {
        return new DireccionDTO(
                direccionModel.getId(),
                direccionModel.getNombreCalle(),
                direccionModel.getNumeroCalle(),
                direccionModel.getDireccionPrincipal(),
                direccionModel.getUsuario());
    }
}
