# Documentación API REST con Swagger
Ejemplo de implementacion de swagger como documentación de un API REST
> Proyecto base generado con Spring Initializr

## Requisitos para el arranque del proyecto

- ### Java 11 (Compatibilidad con Java 8+)

- ### Base de datos MySQL
  Los endpoints del API leen o graban información en una base de datos de tipo MySQL, por lo que necesitaríamos levantar una base de datos en local: 
  - ### Crear la base de datos mediante docker
  
    Si disponemos de docker instalado ya en el equipo podremos hacer uso de los scripts que hay en el proyecto para poder generar la base de datos y poblarla con algo de información, para ello podremos utilizar los siguientes scripts:

    - #### Crear una base de datos con datos de prueba
      ```bash
      $ sh scripts/startDatabaseAndRestoreDump.sh
      ```
      > Hay que tener en cuenta que hay que situarse dentro de la carpeta scripts para poder cargar el dump

    - #### Crear una base de datos vacía:
      ```bash
      $ sh scripts/startDatabase.sh
      ```
   
    - #### Hacer backup de la base de datos:
      ```bash
      $ sh scripts/backupDatabase.sh
      ```
       
  - ### Con base de datos en local:
    - #### Configuración de la base de datos
       - Nombre de la base de datos: `starwarsplanets`
       - Usuario de la base de datos: `powereduser`
       - Contraseña de la base de datos: `password`
   
    - #### Fichero dumpc para datos de prueba
      - El fichero se encuentra en la carpeta `scripts/databasedump`

## Acceso a documentación Swagger
Para poder acceder a la documentación de Swagger podemos hacerlo mediante las url:
- **URL swagger-ui** *(documentación visual interactiva)*: `http://localhost:8080/swagger-ui.html`
- **URL swagger docs** *(documentación en formato json)*: `http://localhost:8080/v2/api-docs` 

---
---

### Fuentes
 - #### Datos de planetas de Star Wars
   - https://es.wikipedia.org/wiki/Anexo:Planetas_y_sat%C3%A9lites_de_Star_Wars
   - https://starwars.fandom.com/es/wiki/Lista_de_planetas
 - #### Librería lombok
   - https://projectlombok.org/
 - #### Sprinfox y Swagger
   - https://springfox.github.io/springfox/docs/current/
   - https://github.com/swagger-api/swagger-ui
 - #### Spring-boot
   - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
   - https://start.spring.io/
 - #### Docker
   - https://docs.docker.com/desktop/windows/install/
   - https://hub.docker.com/_/mysql

---

### Enlaces de interés relacinados
 - #### Generador de librería de cliente de un API
   - https://github.com/swagger-api/swagger-codegen
 - #### Generador de capa de comunicación del API de un backend para Angular, (interfaces de petición y respuesta, servicios de comunicación con endpoints, etc)
   - https://github.com/jnwltr/swagger-angular-generator