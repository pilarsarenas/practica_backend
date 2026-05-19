# Documentación del Proyecto `practica_backend`

## 1. Visión general

Este proyecto es una API REST desarrollada en Java con Spring Boot para la "gestión de usuarios". Incluye:

- Gestión de usuarios (`Usuario`).
- Gestión de géneros (`Genero`).
- Gestión de puestos de trabajo (`PuestoDeTrabajo`).
- Gestión de direcciones (`Direccion`).
- Seguridad básica mediante credenciales enviadas como parámetros de consulta.
- Persistencia en base de datos MySQL mediante Spring Data JPA.
- Migraciones de base de datos con Flyway.
- Documentación de API con OpenAPI / Swagger.

## 2. Estructura de paquetes

- `es.ediae.master.programacion.gestionusuario`
  - `controller`: expone los endpoints REST.
  - `controller.dto`: contiene DTOs usados para documentación y validación.
  - `constant`: constantes de error y claves de respuesta.
  - `entity`: entidades JPA que representan tablas de base de datos.
  - `exception`: excepciones de negocio.
  - `repository`: interfaces JPA para acceso a datos.
  - `service`: modelos y contratos de servicios.
  - `service.impl`: implementación de la lógica de negocio.

## 3. Configuración principal

### `src/main/resources/application.yml`

- `spring.main.allow-circular-references: true`
  - Permite la inyección circular entre `LoginService` y `UsuarioServiceImpl`.
  - Si se desactiva, la aplicación fallaría al arrancar.

- `spring.datasource.url`, `username`, `password`
  - Se cargan desde variables de entorno: `MYSQL_DATABASE_URL`, `MYSQL_DATABASE_USERNAME`, `MYSQL_DATABASE_PASSWORD`.

- `spring.jpa.hibernate.ddl-auto`
  - También se obtiene desde variable `HIBERNATE_DDL_AUTO`.

- `spring.flyway.locations: classpath:db/migration`
  - Flyway ejecuta las migraciones SQL al arranque.

- `springdoc.swagger-ui.path: /api-docs.html`
  - El UI de Swagger queda disponible en esa ruta.

## 4. Punto de entrada

### `src/main/java/es/ediae/master/programacion/gestionusuario/UsuarioApplication.java`

- `@SpringBootApplication` define el arranque de Spring Boot.
- `@OpenAPIDefinition` añade metadata para la documentación OpenAPI.
- `SpringApplication.run(...)` inicia la aplicación.

## 5. Flujo de petición y seguridad

### Flujo general

1. Llega una petición HTTP a un controlador (`controller`).
2. El controlador extrae parámetros y cuerpo JSON.
3. Antes de ejecutar la operación protegida, llama a `loginService.verificar(...)`.
4. `LoginService` usa `UsuarioServiceImpl.iniciarSesion(...)`.
5. `UsuarioServiceImpl.iniciarSesion(...)` consulta el repositorio `IUsuarioRepository`.
6. Si hay coincidencia de usuario y contraseña, la operación continua.
7. La capa de servicio ejecuta la lógica y devuelve modelos a los controladores.

### Importante

- La validación de credenciales no usa tokens ni HTTP headers.
- Se envía el `nickUsuario` y `nickContrasena` como parámetros de consulta (`?nickUsuario=...&nickContrasena=...`).
- `LoginService.verificar(...)` lanza `RuntimeException` si las credenciales son inválidas.
- Ese diseño exige que todas las rutas protegidas reciban estas credenciales.

## 6. Controladores REST

### `UsuarioController`

- Base de URL: `/api/v1`
- `@CrossOrigin(origins = "http://localhost:4200")`
  - Permite llamadas desde un frontend Angular local.

Endpoints:

- `POST /api/v1/login`
  - Cuerpo: `UsuarioPostDTO`.
  - Acción: `iniciarSesion(...)` devuelve `boolean`.
  - Solo comprueba credenciales con la base de datos.

- `GET /api/v1/usuarios`
  - Parámetros: `nickUsuario`, `nickContrasena`.
  - Acción: `obtenerUsuarios(...)` devuelve lista de `UsuarioModel`.

- `GET /api/v1/usuarios/{usuarioId}`
  - Acción: `obtenerUsuario(...)` devuelve un usuario o `null` si no existe.

- `POST /api/v1/usuarios`
  - Cuerpo: `UsuarioModel`.
  - Acción: `crearUsuario(...)`.
  - Valida que `nickUsuario` no exista mediante `existsByNickUsuario(...)`.

- `PUT /api/v1/usuarios/{id}`
  - Actualiza un usuario existente.
  - Comprueba que el `nickUsuario` no se duplique en otro registro.

- `DELETE /api/v1/usuarios/{id}`
  - Elimina el usuario por id.

### Comentario de diseño

- `UsuarioController` usa `UsuarioModel` como DTO de entrada/salida.
- Eso significa que el JSON recibido debe respetar el modelo de servicio.
- El controlador no usa `GeneralControllerUtils` ni `GeneralConstant`.

### `GeneroController`

- Base de URL: `/api/v1/generos`
- Endpoints CRUD estándar:
  - `GET /api/v1/generos`
  - `GET /api/v1/generos/{generoId}`
  - `POST /api/v1/generos`
  - `PUT /api/v1/generos/{id}`
  - `DELETE /api/v1/generos/{id}`
- Cada método llama a la capa de servicio después de validar credenciales.
- `GeneroServiceImpl` comprueba existencia de nombres duplicados.

### `PuestoDeTrabajoController`

- Base de URL: `/api/v1/puestosdetrabajo`
- Endpoints CRUD:
  - `GET /api/v1/puestosdetrabajo`
  - `GET /api/v1/puestosdetrabajo/{puestoDeTrabajoId}`
  - `POST /api/v1/puestosdetrabajo`
  - `PUT /api/v1/puestosdetrabajo/{id}`
  - `DELETE /api/v1/puestosdetrabajo/{id}`
- También valida credenciales en cada petición.

### `DireccionController`

- Base de URL: `/api/v1/direcciones`
- Opera direcciones asociadas a usuarios:
  - `GET /api/v1/direcciones/usuario/{usuarioId}`
  - `GET /api/v1/direcciones/{id}`
  - `POST /api/v1/direcciones`
  - `PUT /api/v1/direcciones/{id}`
  - `DELETE /api/v1/direcciones/{id}`

## 7. Repositorios y persistencia

### `IUsuarioRepository`

- Extiende `JpaRepository<UsuarioEntity, Integer>`.
- Métodos personalizados:
  - `findByNickUsuarioAndContrasena(...)`
  - `existsByNickUsuario(...)`
  - `findByNickUsuario(...)`

### `IGeneroRepository`

- Extiende `JpaRepository<GeneroEntity, Integer>`.
- Métodos personalizados:
  - `findByNombre(...)`
  - `existsByNombre(...)`

### `IPuestoDeTrabajoRepository`

- Extiende `JpaRepository<PuestoDeTrabajoEntity, Integer>`.
- Métodos personalizados:
  - `findByNombre(...)`
  - `existsByNombre(...)`

### `IDireccionRepository`

- Extiende `JpaRepository<DireccionEntity, Integer>`.
- Métodos personalizados:
  - `buscarPorUsuarioId(Integer usuarioId)` con query JPQL.
  - `findByUsuarioIdAndDireccionPrincipalTrue(Integer usuarioId)` para validar la única dirección principal.

## 8. Entidades y relaciones SQL

### `UsuarioEntity`

- Tabla: `usuario`
- Columnas clave:
  - `id` autoincremental.
  - `nick_usuario` único y obligatorio.
  - `contrasena` obligatorio.
  - `genero_id` obligatorio, relación `ManyToOne` con `GeneroEntity`.
  - `puesto_de_trabajo_id` opcional, relación `ManyToOne` con `PuestoDeTrabajoEntity`.
  - `es_admin` booleano, agregado en migración `V3`.

### `GeneroEntity`

- Tabla: `genero`
- Campos:
  - `id`
  - `nombre` único.

### `PuestoDeTrabajoEntity`

- Tabla: `puesto_de_trabajo`
- Campos:
  - `id`
  - `nombre`

### `DireccionEntity`

- Tabla: `direccion`
- Campos:
  - `id`
  - `nombre_calle`
  - `numero_calle`
  - `direccion_principal`
  - `usuario_id` obligatorio, referencia a `usuario.id`

## 9. Modelos de servicio

Los modelos en `service` actúan como adaptadores entre las entidades y la lógica de negocio.

- `UsuarioModel`
  - Contiene los mismos campos que `UsuarioEntity`.
  - Métodos `fromEntity(...)`, `fromDTO(...)`, `fromPostDTO(...)` para transformar datos.
  - Su uso principal es devolver datos al controlador y recibir datos del cliente.

- `GeneroModel`, `PuestoDeTrabajoModel`, `DireccionModel`
  - Siguen el mismo patrón: conversión entre entidad y modelo.

## 10. Lógica de negocio específica

### `UsuarioServiceImpl`

- `obtenerUsuarios(...)`
  - Verifica credenciales.
  - Recupera todos los usuarios mediante `findAll()`.
  - Convierte cada `UsuarioEntity` a `UsuarioModel`.

- `obtenerUsuario(...)`
  - Verifica credenciales.
  - Busca por id con `findById(...)`.
  - Si no existe, devuelve `null`.

- `crearUsuario(...)`
  - Verifica credenciales.
  - Crea `UsuarioEntity` desde `UsuarioModel`.
  - Comprueba `existsByNickUsuario(...)` para evitar duplicados.
  - Guarda la entidad y devuelve el modelo.

- `actualizarUsuario(...)`
  - Verifica credenciales.
  - Busca la entidad por id.
  - Comprueba que el nuevo `nickUsuario` no pertenezca a otro usuario.
  - Actualiza los campos y guarda.

- `eliminarUsuario(...)`
  - Verifica credenciales.
  - Elimina por id.

- `iniciarSesion(...)`
  - Consulta `findByNickUsuarioAndContrasena(...)`.
  - Devuelve `true` si encuentra coincidencia.

### `LoginService`

- `verificar(...)`
  - Llama a `usuarioService.iniciarSesion(...)`.
  - Si la validación falla, lanza `RuntimeException`.
  - Necesita `allow-circular-references` porque `UsuarioServiceImpl` inyecta `LoginService` y `LoginService` inyecta `UsuarioServiceImpl`.

### `GeneroServiceImpl` y `PuestoDeTrabajoServiceImpl`

- Comparten patrón similar:
  - Verificar credenciales.
  - Usar repositorio para CRUD.
  - Validar unicidad de nombre.
  - Retornar `null` si el recurso no existe.

### `DireccionServiceImpl`

- Verifica credenciales.
- Añade restricción de negocio:
  - Solo puede existir una dirección principal por usuario.
  - `validarDireccionPrincipalUnica(...)` busca direcciones principales para el mismo usuario.
- Crea y actualiza direcciones respetando esa regla.

## 11. Migraciones Flyway

### `V1__crear_tablas.sql`

- Crea tablas: `genero`, `puesto_de_trabajo`, `usuario`, `direccion`.
- Define claves foráneas entre `usuario -> genero`, `usuario -> puesto_de_trabajo` y `direccion -> usuario`.

### `V2__rellenar_tabla_fakeentity.sql`

- Inserta datos de ejemplo:
  - Géneros `Hombre`, `Mujer`.
  - Varios puestos de trabajo.
  - Un usuario de ejemplo `jdoe`.
  - Dos direcciones para ese usuario.

### `V3__add_esAdmin_to_usuario.sql`

- Agrega columna `es_admin` a la tabla `usuario`.
- El campo es obligatorio con valor por defecto `FALSE`.

### `V4__unique_nick_usuario.sql`

- Añade restricción única sobre `nick_usuario`.
- Refuerza en la base de datos la regla que ya valida el servicio.

## 12. Dependencias principales (`pom.xml`)

- `spring-boot-starter-web`: API REST.
- `spring-boot-starter-data-jpa`: JPA + Hibernate.
- `spring-boot-starter-validation`: validación de DTOs.
- `flyway-core` + `flyway-mysql`: migraciones de esquema.
- `mysql-connector-j`: driver MySQL.
- `springdoc-openapi-starter-webmvc-ui`: Swagger / OpenAPI UI.

## 13. Observaciones importantes

- `GeneralControllerUtils` está implementado para construir respuestas estándar (`type`, `data`, `exception`) pero no se utiliza en los controladores actuales.
- El sistema de autenticación es muy básico y no utiliza JWT ni cabeceras HTTP.
- Muchos métodos devuelven `null` cuando no encuentran recursos. Esto puede causar respuestas `200` con cuerpo `null` en lugar de `404`.
- Algunas validaciones de datos se definen en DTOs (`@NotBlank`, `@NotNull`) pero no siempre se usan en todos los controladores.
- La dependencia circular entre `LoginService` y `UsuarioServiceImpl` es intencional, y quedaría rota si se eliminara `allow-circular-references`.

---

## 14. Recomendaciones de lectura rápida

- Si quieres entender el arranque de la aplicación: `UsuarioApplication.java`.
- Si quieres ver la seguridad/validación de credenciales: `LoginService.java` y `UsuarioServiceImpl.java`.
- Si quieres saber cómo se persisten usuarios: `UsuarioEntity.java` y `IUsuarioRepository.java`.
- Si quieres entender la base de datos: `src/main/resources/db/migration/V1__crear_tablas.sql`.
- Si buscas los endpoints públicos: los controladores en `src/main/java/es/ediae/master/programacion/gestionusuario/controller/`.
