package es.ediae.master.programacion.gestionusuario.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class GeneroPostDTO {


    private Integer id; 
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    // --- Constructores ---
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

