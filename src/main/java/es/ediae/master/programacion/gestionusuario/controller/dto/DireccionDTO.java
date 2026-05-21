package es.ediae.master.programacion.gestionusuario.controller.dto;

import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO que representa la información de una dirección")
public class DireccionDTO {

    @Schema(description = "Identificador único de la dirección", example = "1")
    private Integer id;

    @NotBlank(message = "El nombre de la calle es obligatorio")
    @Schema(description = "Nombre de la vía o calle", example = "Calle Gran Vía")
    private String nombreCalle;

    @Schema(description = "Número del portal o edificio", example = "25")
    private Integer numeroCalle;

    @Schema(description = "Indica si es la dirección por defecto del usuario", example = "true")
    private Boolean direccionPrincipal;

    @Schema(description = "Datos del usuario asociado a esta dirección")
    private UsuarioDTO usuario; 

    public DireccionDTO() {}

    public DireccionDTO(Integer id, String nombreCalle, Integer numeroCalle, Boolean direccionPrincipal, UsuarioDTO usuario) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.direccionPrincipal = direccionPrincipal;
        this.usuario = usuario;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreCalle() { return nombreCalle; }
    public void setNombreCalle(String nombreCalle) { this.nombreCalle = nombreCalle; }

    public Integer getNumeroCalle() { return numeroCalle; }
    public void setNumeroCalle(Integer numeroCalle) { this.numeroCalle = numeroCalle; }

    public Boolean getDireccionPrincipal() { return direccionPrincipal; }
    public void setDireccionPrincipal(Boolean direccionPrincipal) { this.direccionPrincipal = direccionPrincipal; }

    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }

    public static DireccionDTO fromModel(DireccionModel direccionModel) {
    UsuarioDTO usuarioDTO = null;
    if (direccionModel.getUsuario() != null) {
        usuarioDTO = UsuarioDTO.fromModel(
            UsuarioModel.fromEntity(direccionModel.getUsuario())
        );
    }

    return new DireccionDTO(
            direccionModel.getId(),
            direccionModel.getNombreCalle(),
            direccionModel.getNumeroCalle(),
            direccionModel.getDireccionPrincipal(),
            usuarioDTO);
}

}