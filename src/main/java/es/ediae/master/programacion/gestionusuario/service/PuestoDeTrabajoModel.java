package es.ediae.master.programacion.gestionusuario.service;


import es.ediae.master.programacion.gestionusuario.controller.dto.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.controller.dto.PuestoDeTrabajoPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

public class PuestoDeTrabajoModel {
    
    private Integer id;
    private String nombre;

    public PuestoDeTrabajoModel() {
    }

    public PuestoDeTrabajoModel(Integer id, String nombre) {
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

    public static PuestoDeTrabajoModel fromEntity(PuestoDeTrabajoEntity puestoDeTrabajoEntity) {
        return new PuestoDeTrabajoModel(puestoDeTrabajoEntity.getId(), puestoDeTrabajoEntity.getNombre());
    }
    public static PuestoDeTrabajoModel fromDTO(PuestoDeTrabajoDTO puestoDeTrabajoDTO) {
        return new PuestoDeTrabajoModel(puestoDeTrabajoDTO.getId(), puestoDeTrabajoDTO.getNombre());
    }
       public static PuestoDeTrabajoModel fromPostDTO(PuestoDeTrabajoPostDTO puestoDeTrabajoPostDTO) {
        return new PuestoDeTrabajoModel(
            null,
            puestoDeTrabajoPostDTO.getNombre()
        );
    }
}
