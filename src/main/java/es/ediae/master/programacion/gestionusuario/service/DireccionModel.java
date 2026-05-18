package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.controller.dto.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.controller.dto.DireccionPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

 public class DireccionModel {

    private Integer id;
    private String nombreCalle;
    private Integer numeroCalle;
    private Boolean direccionPrincipal;
    private UsuarioEntity usuario;

    public DireccionModel() {
    }      

    public DireccionModel(Integer id, String nombreCalle, Integer numeroCalle, Boolean direccionPrincipal, UsuarioEntity usuario) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.direccionPrincipal = direccionPrincipal;
        this.usuario = usuario;
    }

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

    public static DireccionModel fromEntity(DireccionEntity direccionEntity) {
        return new DireccionModel(direccionEntity.getId(), direccionEntity.getNombreCalle(), direccionEntity.getNumeroCalle(), direccionEntity.getDireccionPrincipal(), direccionEntity.getUsuario());
    }

    public static DireccionModel fromDTO(DireccionDTO direccionDTO) {
        return new DireccionModel(direccionDTO.getId(), direccionDTO.getNombreCalle(), direccionDTO.getNumeroCalle(), direccionDTO.getDireccionPrincipal(), direccionDTO.getUsuario());
    }

    public static DireccionModel fromPostDTO(DireccionPostDTO direccionPostDTO) {
        return new DireccionModel(null, direccionPostDTO.getNombreCalle(), direccionPostDTO.getNumeroCalle(), direccionPostDTO.getDireccionPrincipal(), direccionPostDTO.getUsuario());
    }


}
