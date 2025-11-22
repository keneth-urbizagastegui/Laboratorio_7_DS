# Laboratorio 07 - Sistema de Microservicios con Docker

## Información del Curso
- **Curso:** Diseño de Software
- **Estudiante:** Keneth
- **Semestre:** 2025-2

## Descripción del Proyecto
Este proyecto implementa un sistema distribuido compuesto por **3 microservicios backend** desarrollados en **Java Spring Boot 3** con **JPA**. El sistema utiliza una base de datos centralizada **PostgreSQL** y un Frontend renderizado en el servidor utilizando **Thymeleaf** y **Bootstrap 5** para la interfaz de usuario. Todo el tráfico es orquestado y distribuido por un **API Gateway** implementado con **Nginx**.

## Arquitectura del Sistema

| Servicio | Tecnología | Puerto Interno | Puerto Host (Acceso) | URL |
| :--- | :--- | :--- | :--- | :--- |
| **Nginx Load Balancer** | Nginx | 80 | **7000** | [http://localhost:7000](http://localhost:7000) |
| **Microservicio Clientes** | Spring Boot | 5001 | - | - |
| **Microservicio Productos** | Spring Boot | 6001 | - | - |
| **Microservicio Proveedores** | Spring Boot | 7001 | - | - |
| **Base de Datos** | PostgreSQL | 5432 | 5432 | - |

## Instrucciones de Uso

### Despliegue
Para iniciar todo el sistema, ejecuta el siguiente comando en la raíz del proyecto:

```bash
docker-compose up --build
```

### Acceso a los Módulos
Una vez iniciado el sistema, puedes acceder a los diferentes módulos a través del API Gateway (Puerto 7000):

- **Clientes:** [http://localhost:7000/clientes](http://localhost:7000/clientes)
- **Productos:** [http://localhost:7000/productos](http://localhost:7000/productos)
- **Proveedores:** [http://localhost:7000/proveedores](http://localhost:7000/proveedores)

## ⚠️ Reinicio Limpio (Importante)
Si observas datos duplicados o inconsistencias en la base de datos, es recomendable realizar un reinicio limpio borrando los volúmenes persistentes. Ejecuta:

```bash
docker-compose down -v
```

Luego, vuelve a levantar el sistema con el comando de despliegue.
