package es.ediae.master.programacion.gestionusuario.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "PuestoDeTrabajoPost", description = "Datos necesarios para dar de alta un nuevo puesto de trabajo")
public class PuestoDeTrabajoPostDTO {

    @Schema(hidden = true)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Nombre del puesto de trabajo", example = "Director de Proyectos", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    public PuestoDeTrabajoPostDTO() {
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
}