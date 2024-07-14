## 📜 Foro - Tecer Desafio

Api elaborado con el objetivo de construir un CRUD para un foro con Java y Spring Boot

### Prerequisitos

Antes de consumir esta Api, debes de tener instalado los siguientes pasos y programas:

- Clonar este repositorio con GitHub.
- Disponer en tu PC de tu entorno de desarrollo integrado como: IntelliJ IDEA``

## Instalación 🔧

- Abrir proyecto desde IntelliJ IDEA

## Ejecución 🛠️
Para ejecutar la Api desde local, puede seguir los siguientes pasos:  

``` 
Paso 1
Ir a la clase ApiApplication + boton derecho Run "Api Application... main()"

Paso 2
Una vez en ejecucion, utilizando insomnia o postman tendra la oportunidad de :

********************************************** 

Crear un login de Usuario: Cualquier persona puede registrarse en el sistema, colocando un login y clave para y podra
obtener un token JWT.
Crear Tópicos: Solo los usuarios autenticados pueden crear nuevos tópicos.
Listar Tópicos: Solo los usuarios autenticados, puede listar todos los tópicos del foro.
Eliminar Tópicos: Solo los usuarios autenticados pueden eliminar tópicos, el cual solo quedara inactivo en la base de datos.

**********************************************
```
## Ejemplo de url que podras visualizar segun el caso

```
http://localhost:8080/login
request:
{
	"login":"maria.lara",
	"clave": "123456"
}
response:
{
	"jwTtoken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYS5sYXJhIiwiaXNzIjoiZm9ybyIsImlkIjoxLCJleHAiOjE3MjEwMDUyNTh9.Db3o-PLluwRJKvZjxszCR4fBMpjHthIBpB0xE-ZS7qQ"
}
```

## Construido con 🛠️

* [IntelliJ IDEA 2023.2.1 (Community Edition)]
* [Insomnia 9.3.2]
* [MySQL Workbench 8.0]

## Autor ✒️

Maria Lara

=======
# API Foro

