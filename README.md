# 🚀 Generador de Mensajes Automáticos para Discord

## 📌 Descripción
Este proyecto es un servicio backend desarrollado con **Java + Spring Boot + PostgreSQL**, que permite programar mensajes y enviarlos automáticamente a un servidor de **Discord** a través de **webhooks**.

## ✨ Características
- 📩 **Programar mensajes** con fecha y hora específicas.
- 📜 **Consultar mensajes** programados.
- 🗑 **Eliminar mensajes**.
- 🤖 **Enviar mensajes automáticos** a un servidor de Discord mediante un **webhook**.
- 📖 **Documentación con Swagger UI**.

## 🛠️ Tecnologías Utilizadas
- Java 17 + Spring Boot 3
- PostgreSQL
- WebClient (para enviar mensajes a Discord)
- Maven

---

## 🚀 Instalación y Configuración

### 1️⃣ Clonar el repositorio

### 2️⃣ Configurar el archivo `application.properties`
Edita el archivo `src/main/resources/application.properties` con tus credenciales de base de datos y el webhook de Discord.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mensajes_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# Webhook de Discord
webhook.url=https://discord.com/api/webhooks/TU_WEBHOOK
```

### 3️⃣ Ejecutar el proyecto

## 📝 Uso de la API

### 📩 Programar un Mensaje (POST `/message`)

- En Postman crea un HTTP Request del tipo Post.
- Ingresa el link  "http://localhost:8080/message" \
- Agrega un body en formato JSON que contenga los parámetros "texto" y "fecha" (dd/MM/yyyy:HH:mm).
  Ejemplo: {"texto": "Hola Discord", "fecha": "14/02/2025:12:30"}


### 📜 Obtener Mensajes Programados (GET `/messages`)
- Puedes obtener los mensajes programados en "http://localhost:8080/message"


### 🗑 Eliminar un Mensaje (DELETE `/message/{id}`)
- Los mensajes se eliminan automáticamente cuando se envían, sin embargo, puedes eliminarlos manualmente con el ID. Ejemplo: 
    "http://localhost:8080/message/1"


## 📖 Documentación con Swagger UI
La documentación de la API está disponible en:
🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🤖 Configuración del Webhook de Discord
Para enviar mensajes programados a tu servidor de Discord:
1. Ve a **Configuración del Servidor** → **Integraciones** → **Crear Webhook**.
2. Copia la URL del Webhook y agrégala en `application.properties`.
3. ¡Listo! Tu bot enviará los mensajes automáticamente. 🚀

## 🖥️ Panel Web para Visualizar Mensajes

Se ha añadido un panel web simple utilizando **Thymeleaf** para visualizar los mensajes programados en la aplicación.

### 📌 Acceso al Panel
Una vez que la aplicación está en ejecución, puedes acceder al panel en:  
[`http://localhost:8080/panel`](http://localhost:8080/panel)

### 📄 Características
- Muestra la lista de mensajes programados.
- Se actualiza dinámicamente con los mensajes almacenados en la base de datos.
