package es.ediae.master.programacion.gestionusuario.controller.dto;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO que representa la información de un puesto de trabajo")
public class PuestoDeTrabajoDTO {

    @Schema(description = "Identificador único del puesto de trabajo", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Nombre o título del cargo", example = "Analista Programador", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    public PuestoDeTrabajoDTO() {
    }

    public PuestoDeTrabajoDTO(Integer id, String nombre) {
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

    public static PuestoDeTrabajoDTO fromModel(PuestoDeTrabajoEntity puestoDeTrabajoEntity) {
        return new PuestoDeTrabajoDTO(
                puestoDeTrabajoEntity.getId(),
                puestoDeTrabajoEntity.getNombre());
    }
}