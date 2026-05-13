package es.ediae.master.programacion.gestionusuario.controller.dto;

import es.ediae.master.programacion.gestionusuario.service.GeneroModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO que representa la información de un género")
public class GeneroDTO {

    @Schema(description = "Identificador único del género", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Descripción del género", example = "Masculino", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    public GeneroDTO() {
    }

    public GeneroDTO(Integer id, String nombre) {
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

    public static GeneroDTO fromModel(GeneroModel generoModel) {
        return new GeneroDTO(
                generoModel.getId(),
                generoModel.getNombre());
    }
}