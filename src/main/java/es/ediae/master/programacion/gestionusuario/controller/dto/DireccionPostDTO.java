package es.ediae.master.programacion.gestionusuario.controller.dto;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "DireccionPost", description = "Objeto necesario para crear una nueva dirección en el sistema")
public class DireccionPostDTO {

    @Schema(hidden = true) // Ocultamos el ID porque en un POST de creación no suele ser necesario enviarlo
    private Integer id;

    @NotBlank(message = "El nombre de la calle es obligatorio")
    @Schema(description = "Nombre de la calle o vía pública", example = "Calle Alhamar", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreCalle;

    @Schema(description = "Número del inmueble", example = "42")
    private Integer numeroCalle;

    @Schema(description = "Marca si la dirección debe ser la principal del usuario", example = "false")
    private Boolean direccionPrincipal;

    @Schema(description = "Información del usuario propietario de la dirección")
    private UsuarioEntity usuario;

    public DireccionPostDTO() {
    }

    public DireccionPostDTO(String nombreCalle, Integer numeroCalle, Boolean direccionPrincipal,
            UsuarioEntity usuario) {
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.direccionPrincipal = direccionPrincipal;
        this.usuario = usuario;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public Boolean getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(Boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}