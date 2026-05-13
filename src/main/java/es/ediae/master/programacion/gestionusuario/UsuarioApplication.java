package es.ediae.master.programacion.gestionusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "API de Gestión de Usuarios",
				version = "1.9x",
				description = "Documentación de la API para el sistema de gestión de usuarios, " +
                      "incluyendo operaciones CRUD para y validación de credenciales."
		)
)
@SpringBootApplication
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
