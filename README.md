# 🦷 Sistema de Gestión Odontológica "Sonrisa Feliz"

## ✨ Visión General del Proyecto

Este proyecto aborda la **digitalización integral de la gestión de turnos** y la información de pacientes para la clínica "Sonrisa Feliz". El objetivo es reemplazar la gestión manual (libretas) por un sistema moderno que garantice la **trazabilidad**, **disponibilidad de la información**, y mejore la experiencia tanto de los pacientes como de los profesionales.

El desarrollo se lleva a cabo bajo una **metodología ágil (Scrum académico)**, enfocada en la entrega de valor incremental y la evolución consciente de la arquitectura de software.

---

## 🎯 Objetivos Clave

* **Gestión Centralizada:** Implementar el CRUD (Crear, Leer, Actualizar, Eliminar) de las entidades principales: **Pacientes** (con Domicilio asociado) y **Odontólogos**.
* **Evolución Arquitectónica:** Transitar desde un patrón **DAO** inicial (acoplamiento consciente) hacia una arquitectura **MVC** y la adopción de **ORM con Spring Data JPA**.
* **Interoperabilidad:** Exponer la lógica de negocio a través de **APIs REST**.
* **Calidad:** Implementar **validaciones**, **manejo global de excepciones** y **logging** consistente (Log4j).

---

## 🛠️ Stack Tecnológico

El proyecto está construido sobre una arquitectura **monolítica en capas**, con el siguiente stack tecnológico:

| Componente | Detalle |
| :--- | :--- |
| **Lenguaje** | Java 21 |
| **Framework** | Spring Boot 3.5.2 |
| **Build Tool** | Maven |
| **Persistencia Inicial** | **H2 Database** (En memoria, para desarrollo y testing) |
| **Patrones** | DAO (Inicial) $\rightarrow$ MVC / Repository (Futuro) |
| **Logging** | Log4j |
| **Testing** | JUnit 5 |

---

## 🚀 Cómo Empezar

Para poner en marcha el proyecto:

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/MatiasReal/microsyapis.git](https://github.com/MatiasReal/microsyapis.git)
    cd microsyapis
    ```
2.  **Abrir en IDE:** Importar el proyecto como un proyecto Maven en tu IDE (IntelliJ IDEA, VS Code, etc.).
3.  **Ejecutar:** Ejecutar la clase principal de Spring Boot. La base de datos H2 se inicializará automáticamente, y podrás interactuar con los DAOs a través de los Services en la consola/pruebas iniciales.
4.  **H2 Console:** Por defecto, la consola H2 estará disponible en: `http://localhost:8080/h2-console` (configuración pendiente de definir en `application.properties`).
