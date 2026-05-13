package es.ediae.master.programacion.gestionusuario.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(name = "UsuarioPostDTO", description = "Modelo para la creación de un nuevo usuario en el sistema")
public class UsuarioPostDTO {

    @NotBlank(message = "El nick de usuario es obligatorio")
    @Schema(description = "Nombre de usuario único", example = "alberto_dev", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nickUsuario;

    @NotBlank(message = "La contrasena no puede estar vacía")
    @Schema(description = "Contraseña segura del usuario", example = "STr0ng_P4ss!", format = "password", requiredMode = Schema.RequiredMode.REQUIRED)
    private String contrasena;

    @NotNull(message = "La fecha de creación es obligatoria")
    @Schema(description = "Marca de tiempo de la creación", example = "2024-05-13T10:15:30")
    private LocalDateTime fechaHoraCreacion;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre real del usuario", example = "Alberto")
    private String nombre;

    @NotBlank(message = "El primer apellido es obligatorio")
    @Schema(description = "Primer apellido", example = "García")
    private String primerApellido;

    @Schema(description = "Segundo apellido (opcional)", example = "Sánchez")
    private String segundoApellido;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Schema(description = "Fecha de nacimiento", example = "1992-08-24")
    private LocalDate fechaNacimiento;

    @Schema(description = "Hora de descanso/desayuno asignada", example = "10:30:00")
    private LocalTime horaDesayuno;

    @NotNull(message = "El género es obligatorio")
    @Schema(description = "Referencia al género")
    private GeneroEntity genero;

    @Schema(description = "Referencia al puesto de trabajo asignado")
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    @Schema(description = "Indica si el usuario tiene rol de administrador", example = "false")
    private boolean esAdmin;

    public UsuarioPostDTO() {
    }

    public UsuarioPostDTO(String nickUsuario, String contrasena, LocalDateTime fechaHoraCreacion,
            String nombre, String primerApellido, String segundoApellido,
            LocalDate fechaNacimiento, LocalTime horaDesayuno,
            GeneroEntity genero, PuestoDeTrabajoEntity puestoDeTrabajo, boolean esAdmin) {

        this.nickUsuario = nickUsuario;
        this.contrasena = contrasena;
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

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
}