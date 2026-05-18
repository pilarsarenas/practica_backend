package es.ediae.master.programacion.gestionusuario.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import es.ediae.master.programacion.gestionusuario.controller.dto.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.controller.dto.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public class UsuarioModel {
    
    private Integer id;
    private String nickUsuario;
    private String contrasena;
    private LocalDateTime fechaHoraCreacion;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private LocalTime horaDesayuno;
    private GeneroEntity genero;
    private PuestoDeTrabajoEntity puestoDeTrabajo;
    private boolean esAdmin;

    public UsuarioModel() {}

    public UsuarioModel(Integer id, String nickUsuario, String contrasena, LocalDateTime fechaHoraCreacion,
            String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento,
            LocalTime horaDesayuno, GeneroEntity genero, PuestoDeTrabajoEntity puestoDeTrabajo, boolean esAdmin) {
        this.id = id;
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

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

        public static UsuarioModel fromEntity(UsuarioEntity usuarioEntity) {
    return new UsuarioModel(
        usuarioEntity.getId(),
        usuarioEntity.getNickUsuario(),
       usuarioEntity.getContrasena(),
        usuarioEntity.getFechaHoraCreacion(),
        usuarioEntity.getNombre(),
        usuarioEntity.getPrimerApellido(),
        usuarioEntity.getSegundoApellido(),
        usuarioEntity.getFechaNacimiento(),
        usuarioEntity.getHoraDesayuno(),
        usuarioEntity.getGenero(),
        usuarioEntity.getPuestoDeTrabajo(),
        usuarioEntity.isEsAdmin()
    );
}

    public static UsuarioModel fromDTO(UsuarioDTO usuarioDTO) {
        return new UsuarioModel(
            usuarioDTO.getId(),
            usuarioDTO.getNickUsuario(),
            usuarioDTO.getContrasena(),
            usuarioDTO.getFechaHoraCreacion(),
            usuarioDTO.getNombre(),
            usuarioDTO.getPrimerApellido(),
            usuarioDTO.getSegundoApellido(),
            usuarioDTO.getFechaNacimiento(),
            usuarioDTO.getHoraDesayuno(),
            usuarioDTO.getGenero(),
            usuarioDTO.getPuestoDeTrabajo(),
            usuarioDTO.isEsAdmin()
        );
    }

    public static UsuarioModel fromPostDTO(UsuarioPostDTO usuarioPostDTO) {
        return new UsuarioModel(
            null,
            usuarioPostDTO.getNickUsuario(),
            usuarioPostDTO.getContrasena(),
            LocalDateTime.now(),
            usuarioPostDTO.getNombre(),
            usuarioPostDTO.getPrimerApellido(),
            usuarioPostDTO.getSegundoApellido(),
            usuarioPostDTO.getFechaNacimiento(),
            usuarioPostDTO.getHoraDesayuno(),
            usuarioPostDTO.getGenero(),
            usuarioPostDTO.getPuestoDeTrabajo(),
            usuarioPostDTO.isEsAdmin()
        );
    }

}
