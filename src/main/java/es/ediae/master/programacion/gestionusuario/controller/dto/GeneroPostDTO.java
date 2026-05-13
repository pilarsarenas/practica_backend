package es.ediae.master.programacion.gestionusuario.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "GeneroPost", description = "Datos requeridos para registrar un nuevo género")
public class GeneroPostDTO {

    @Schema(hidden = true) // El ID no se envía en un POST de creación, se autogenera
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Nombre descriptivo del género", example = "Femenino", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    public GeneroPostDTO() {
    }

    public GeneroPostDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // --- Getters y Setters ---
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