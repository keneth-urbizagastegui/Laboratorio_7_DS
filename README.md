# Laboratorio 07 - Despliegue de Microservicios con Docker

## Integrante
* **Nombre:** Keneth
* **Curso:** Diseño de Software

## Descripción
Sistema de microservicios desarrollado en Java Spring Boot, orquestado con Docker Compose. Incluye 3 servicios independientes, base de datos PostgreSQL y un balanceador de carga Nginx.

## Arquitectura
* **Balanceador (Nginx):** Puerto 7000
* **Ms-Clientes:** Puerto interno 5001
* **Ms-Productos:** Puerto interno 6001
* **Ms-Proveedores:** Puerto interno 7001
* **Base de Datos:** PostgreSQL (Puerto 5432)

## Pre-requisitos
* Docker y Docker Desktop instalados.

## Instrucciones de Ejecución
1. Clonar el repositorio o descargar la carpeta.
2. Abrir una terminal en la raíz del proyecto.
3. Ejecutar el comando de construcción y despliegue:
   ```bash
   docker-compose up --build
   ```
