package es.ediae.master.programacion.gestionusuario.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    private Integer id;
    @NotBlank(message = "El nick de usuario es obligatorio")
    private String nickUsuario;
    @NotBlank(message = "La contrasena no puede estar vacía")
    private String contrasena;
    @NotNull(message = "La fecha de creación es obligatoria")
    private LocalDateTime fechaHoraCreacion;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;
    private String segundoApellido;
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;
    private LocalTime horaDesayuno;
    @NotNull(message = "El género es obligatorio")
    private GeneroEntity genero;
    private PuestoDeTrabajoEntity puestoDeTrabajo;
    private Boolean esAdmin;

    // --- Constructores ---
    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nickUsuario, LocalDateTime fechaHoraCreacion,
            String nombre, String primerApellido, String segundoApellido,
            LocalDate fechaNacimiento, LocalTime horaDesayuno,
            GeneroEntity genero, PuestoDeTrabajoEntity puestoDeTrabajo, Boolean esAdmin) {
        this.id = id;
        this.nickUsuario = nickUsuario;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.horaDesayuno = horaDesayuno;
        this.genero = genero;
        this.puestoDeTrabajo = puestoDeTrabajo;
        this.esAdmin = esAdmin;
    }

    // --- Getters y Setters ---
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalTime getHoraDesayuno() {
        return horaDesayuno;
    }

    public void setHoraDesayuno(LocalTime horaDesayuno) {
        this.horaDesayuno = horaDesayuno;
    }

    public GeneroEntity getGenero() {
        return genero;
    }

    public void setGenero(GeneroEntity genero) {
        this.genero = genero;
    }

    public PuestoDeTrabajoEntity getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public Boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public static UsuarioDTO fromModel(UsuarioModel usuarioModel) {
        return new UsuarioDTO(
                usuarioModel.getId(),
                usuarioModel.getNickUsuario(),
                usuarioModel.getFechaHoraCreacion(),
                usuarioModel.getNombre(),
                usuarioModel.getPrimerApellido(),
                usuarioModel.getSegundoApellido(),
                usuarioModel.getFechaNacimiento(),
                usuarioModel.getHoraDesayuno(),
                usuarioModel.getGenero(),
                usuarioModel.getPuestoDeTrabajo(),
                usuarioModel.isEsAdmin());
    }

}
