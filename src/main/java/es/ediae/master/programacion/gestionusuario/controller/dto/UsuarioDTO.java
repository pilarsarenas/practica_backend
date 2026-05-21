package es.ediae.master.programacion.gestionusuario.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de transferencia de datos para la gestión de usuarios")
public class UsuarioDTO {

    @Schema(description = "Identificador único del usuario", example = "1")
    private Integer id;

    @Schema(description = "Nombre de usuario o alias", example = "jdoe88")
    private String nickUsuario;

    @Schema(description = "Fecha y hora de registro en el sistema", example = "2023-10-27T10:00:00")
    private LocalDateTime fechaHoraCreacion;

    @Schema(description = "Nombre", example = "John")
    private String nombre;

    @Schema(description = "Primer apellido", example = "Doe")
    private String primerApellido;

    @Schema(description = "Segundo apellido (opcional)", example = "Smith")
    private String segundoApellido;

    @Schema(description = "Fecha de nacimiento del usuario", example = "1990-01-01")
    private LocalDate fechaNacimiento;

    @Schema(description = "Hora preferida de desayuno", example = "08:30:00")
    private LocalTime horaDesayuno;

    @Schema(description = "Entidad que define el género del usuario")
    private GeneroEntity genero;

    @Schema(description = "Puesto de trabajo asignado")
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    @Schema(description = "Indica si el usuario tiene privilegios de administrador", example = "false")
    private Boolean esAdmin;

    public UsuarioDTO() {}

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNickUsuario() { return nickUsuario; }
    public void setNickUsuario(String nickUsuario) { this.nickUsuario = nickUsuario; }

    public LocalDateTime getFechaHoraCreacion() { return fechaHoraCreacion; }
    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) { this.fechaHoraCreacion = fechaHoraCreacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public LocalTime getHoraDesayuno() { return horaDesayuno; }
    public void setHoraDesayuno(LocalTime horaDesayuno) { this.horaDesayuno = horaDesayuno; }

    public GeneroEntity getGenero() { return genero; }
    public void setGenero(GeneroEntity genero) { this.genero = genero; }

    public PuestoDeTrabajoEntity getPuestoDeTrabajo() { return puestoDeTrabajo; }
    public void setPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) { this.puestoDeTrabajo = puestoDeTrabajo; }

    public Boolean isEsAdmin() { return esAdmin; }
    public void setEsAdmin(Boolean esAdmin) { this.esAdmin = esAdmin; }

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