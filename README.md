# Sistema de Gestión - Asociación Solidarista Empresarial

Sistema de gestión desarrollado en Java con NetBeans para la administración de una asociación solidarista empresarial.

## 📋 Descripción

Sistema completo de gestión que permite administrar:
- **Asociados**: Registro y gestión de miembros de la asociación
- **Programas**: Gestión de programas de capacitación y desarrollo
- **Inscripciones**: Control de inscripciones a programas
- **Comunicación**: Gestión de comunicaciones con miembros
- **Participación**: Seguimiento de participación en programas
- **Transacciones Financieras**: Control de transacciones
- **Préstamos**: Administración de préstamos
- **Dividendos**: Gestión de dividendos

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación
- **NetBeans**: IDE de desarrollo
- **Oracle Database**: Base de datos
- **Swing**: Interfaz gráfica de usuario
- **JDBC**: Conexión a base de datos
- **Stored Procedures**: Lógica de negocio en Oracle

## ✨ Características

- ✅ Validaciones en tiempo real con expresiones regulares
- ✅ Validaciones en capa de aplicación (Java) y base de datos (SQL)
- ✅ Interfaz gráfica intuitiva
- ✅ Gestión completa de CRUD para todas las entidades
- ✅ Validación de formatos de datos (fechas, números, textos)
- ✅ Mensajes de error descriptivos

## 📁 Estructura del Proyecto

```
AsociacionSolidarista/
├── src/
│   ├── asociacionsolidarista/    # Clase principal
│   ├── Conector/                 # Conexión a base de datos
│   ├── Controlador/              # Lógica de control
│   ├── Modelo/                   # Modelos de datos
│   ├── Vista/                    # Interfaz gráfica
│   └── Imagenes/                 # Recursos gráficos
├── build/                        # Archivos compilados
├── dist/                         # Distribución
└── nbproject/                    # Configuración NetBeans
```

## 🚀 Requisitos

- Java JDK 8 o superior
- NetBeans IDE
- Oracle Database
- Driver JDBC de Oracle (ojdbc11.jar)

## 📝 Configuración

1. Clonar el repositorio
2. Abrir el proyecto en NetBeans
3. Configurar la conexión a Oracle en `Conector.java`
4. Ejecutar los scripts SQL de creación de tablas y stored procedures
5. Compilar y ejecutar el proyecto

## 👥 Autores

Grupo No. 2 - SC404 - Lenguajes de Base de Datos

## 📄 Licencia

Este proyecto es parte de un trabajo académico.

