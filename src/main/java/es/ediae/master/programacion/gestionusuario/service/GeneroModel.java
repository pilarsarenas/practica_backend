package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.controller.dto.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.controller.dto.GeneroPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;

public class GeneroModel {
    
    private Integer id;
    private String nombre;

    public GeneroModel() {
    }

    public GeneroModel(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static GeneroModel fromEntity(GeneroEntity generoEntity) {
        return new GeneroModel(generoEntity.getId(), generoEntity.getNombre());
    }

    public static GeneroModel fromDTO(GeneroDTO generoDTO) {
        return new GeneroModel(generoDTO.getId(), generoDTO.getNombre());
    }

     public static GeneroModel fromPostDTO(GeneroPostDTO generoPostDTO) {
        return new GeneroModel(
            null,
            generoPostDTO.getNombre()
        );
    }
}
