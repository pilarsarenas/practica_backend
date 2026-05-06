package es.ediae.master.programacion.gestionusuario.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class PuestoDeTrabajoDTO {

    private Integer id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

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
}
