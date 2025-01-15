---

# Foro Hub API

Foro Hub API es una aplicación desarrollada en Java con Spring Boot. Permite gestionar un foro de discusión donde los usuarios pueden crear, visualizar, actualizar y eliminar tópicos.

---

## Características

- **Crear nuevos tópicos** con título, mensaje, autor y curso asociado.
- **Consultar** todos los tópicos o un tópico específico por su ID.
- **Actualizar** la información de un tópico existente.
- **Eliminar** un tópico por su ID.

---

## Tecnologías

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Insomnia** (para probar la API)

---

## Requisitos previos

- **Java Development Kit (JDK) 17** o superior
- **MySQL** instalado y configurado
- **Insomnia** o cualquier cliente REST para probar la API
- **Maven** para la gestión de dependencias

---

## Configuración inicial

1. **Clonar el repositorio**:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd foro_hub_api
   ```

2. **Configurar la base de datos**:
   - Asegúrate de tener una base de datos MySQL creada (por ejemplo, `foro_hub_db`).
   - Modifica el archivo `application.properties` para incluir la configuración de tu base de datos:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub_db
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Construir y ejecutar el proyecto**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## Endpoints de la API

### Base URL

`http://localhost:8080/api/topics`

### Endpoints disponibles

#### 1. **Crear un nuevo tópico**

- **Método**: `POST`
- **URL**: `/api/topics`
- **Body** (JSON):
  ```json
  {
    "title": "Tema de prueba",
    "message": "Este es un mensaje de prueba",
    "author": "Juan Pérez",
    "course": "Java"
  }
  ```
- **Respuesta exitosa**:
  - Código: `201 Created`
  - Cuerpo:
    ```json
    {
      "id": 1,
      "title": "Tema de prueba",
      "message": "Este es un mensaje de prueba",
      "author": "Juan Pérez",
      "course": "Java"
    }
    ```

#### 2. **Obtener todos los tópicos**

- **Método**: `GET`
- **URL**: `/api/topics`
- **Respuesta exitosa**:
  - Código: `200 OK`
  - Cuerpo: Lista de tópicos en formato JSON.

#### 3. **Obtener un tópico por ID**

- **Método**: `GET`
- **URL**: `/api/topics/{id}`
- **Respuesta exitosa**:
  - Código: `200 OK`
  - Cuerpo: Tópico con el ID especificado.

#### 4. **Actualizar un tópico**

- **Método**: `PUT`
- **URL**: `/api/topics/{id}`
- **Body** (JSON):
  ```json
  {
    "title": "Tema actualizado",
    "message": "Este es el mensaje actualizado",
    "author": "Juan Pérez",
    "course": "Java avanzado"
  }
  ```
- **Respuesta exitosa**:
  - Código: `200 OK`
  - Cuerpo: Tópico actualizado.

#### 5. **Eliminar un tópico**

- **Método**: `DELETE`
- **URL**: `/api/topics/{id}`
- **Respuesta exitosa**:
  - Código: `204 No Content`

---

## Pruebas de la API con Insomnia

1. Instala [Insomnia](https://insomnia.rest/download).
2. Crea un nuevo espacio de trabajo y agrega solicitudes para los endpoints descritos anteriormente.
3. Configura el body para las solicitudes POST y PUT utilizando JSON.

---

## Contribuciones

Si deseas contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y haz commit:
   ```bash
   git commit -m "Agrega nueva funcionalidad"
   ```
4. Haz un push a tu rama:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Crea un pull request.

---

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más información.

---
