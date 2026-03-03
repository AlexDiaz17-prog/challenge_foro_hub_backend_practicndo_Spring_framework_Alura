# challenge_foro_hub_backend_practicndo_Spring_framework_Alura
Challenge de Alura foro hub practica con Spring


# 📚 ForoHub API

### Challenge Backend - Alura

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Status](https://img.shields.io/badge/Status-Completed-success)

API REST desarrollada con **Spring Boot** como parte del Challenge Backend de Alura.

El proyecto implementa una arquitectura en capas, persistencia con JPA, seguridad con Spring Security y conexión a base de datos PostgreSQL.

---

## 🚀 Objetivo del Challenge

Desarrollar una API REST para la gestión de tópicos en un foro, aplicando:

* Buenas prácticas de arquitectura
* Persistencia con JPA
* Seguridad básica
* Validaciones
* Paginación

---

## 🏗️ Arquitectura del Proyecto

El proyecto está organizado siguiendo el patrón de arquitectura en capas:

```
controller  → Endpoints REST
service     → Lógica de negocio
repository  → Acceso a datos
model       → Entidades JPA
dto         → Transferencia de datos
config      → Configuraciones (Security)
```

Esto permite mantener el código desacoplado, escalable y mantenible.

---

## 🛠️ Tecnologías Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven
* Lombok

---

## 🔐 Seguridad

La aplicación utiliza **Spring Security con autenticación básica (Basic Auth)**.

Al iniciar la aplicación, Spring genera automáticamente una contraseña que se muestra en consola:

```
Using generated security password: xxxxxxxxx
```

Usuario por defecto:

```
user
```

---

## 📦 Endpoints Disponibles

### 🔎 Listar tópicos

**GET** `/topicos`

Devuelve una lista paginada de los tópicos registrados.

Ejemplo:

```
http://localhost:8080/topicos
```

Respuesta:

```json
{
  "content": [],
  "totalElements": 0,
  "totalPages": 0
}
```

---

### 📝 Crear un tópico

**POST** `/topicos`

Body (JSON):

```json
{
  "titulo": "Mi primer topico",
  "mensaje": "Estoy probando Spring",
  "autor": "Alexis",
  "curso": "Spring Boot"
}
```

Respuesta:

```json
{
  "id": 1,
  "titulo": "Mi primer topico",
  "mensaje": "Estoy probando Spring",
  "fechaCreacion": "2026-03-03T14:42:13",
  "status": true,
  "autor": "Alexis",
  "curso": "Spring Boot"
}
```

---

## 🗄️ Base de Datos

Se utilizó **PostgreSQL**.

Tabla principal:

**topicos**

Campos:

* id (Long - autogenerado)
* titulo (String)
* mensaje (TEXT)
* fecha_creacion (LocalDateTime)
* status (Boolean)
* autor (String)
* curso (String)

---

## ⚙️ Cómo Ejecutar el Proyecto

### 1️⃣ Clonar el repositorio

```
git clone https://github.com/TU-USUARIO/forohub.git
```

### 2️⃣ Configurar la base de datos

Editar el archivo `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/forohub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Ejecutar la aplicación

```
mvn spring-boot:run
```

La aplicación estará disponible en:

```
http://localhost:8080
```

---

## 📈 Estado del Proyecto

✔ Creación de tópicos
✔ Listado paginado
✔ Persistencia en PostgreSQL
✔ Seguridad básica con Spring Security
✔ Arquitectura en capas

---

## 👨‍💻 Autor

**Alexis Parra Diaz**
Ingeniero en Mecatrónica
Backend Developer Java en formación

---

## 📌 Notas Finales

Este proyecto fue desarrollado como parte del proceso de formación en Backend con Java y Spring Boot, aplicando conceptos fundamentales de desarrollo profesional de APIs REST.
