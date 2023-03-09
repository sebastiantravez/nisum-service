# nisum-service

Proyecto realizado bajo clean architecture

Clonar proyecto desde el repositorio.

Descargar las dependencias del build.gradle.

El proyecto fue desarrollado con flyway para la creacion de tablas y carga de datos iniciales, dentro del archivo: /resources/db/migration/V1.0__create_tables.sql se encuentran el script para creacion de tablas y carga de datos iniciales.

El proyecto se despliega en el puerto 8080 de acuerdo a la configuración en el archivo application.properties

El contextPath de la app esta configurado con el valor /api.

Las configuraciones de las expresiones regulares en la base de datos se cargan en el arranque inicial.

Para probar los endpoint en la carpeta de resorces en la capa de /infrastructure se encuentra el json de los endpoints para porbarlos se debe importar el archivo nisum-service.postman_collection.json se lo debe hacer con postman.

Para ingresar a la consola de h2: http://localhost:8080/api/h2-console Datos para configurar conexión a la base de datos: Driver Class: org.h2.Driver JDBC URL: jdbc:h2:mem:nisum username: admin / password: admin

El proyecto tiene la swagger para la documentacion y test de end points, para ingresar apuntar la siguiente ruta: http://localhost:8080/api/swagger-ui/index.html#/

El diagrama de la solución se encuentra en la ruta: /nisum-service/infrastructure/src/main/resources/diagrama-solucion.png
