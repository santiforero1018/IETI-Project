# IETI-Project

Este proyecto tiene como objetivo proporcionar servicios de monitoreo para la luz, agua y gas, permitiendo a los usuarios tener un mejor control de sus gastos. Nuestro enfoque busca contribuir a una mejora continua tanto para el medio ambiente como para la economía de nuestros usuarios.

## Video Demostrativo para la segunda entrega

Puedes ver una demostración de nuestro proyecto en el siguiente enlace:
[Ver Video](https://youtu.be/ctN9euXcCTA)

## Integrantes del Equipo

- [Sebatian Cepeda](https://github.com/Sebasian-Cepeda)
- [Santiago Forero](https://github.com/santiforero1018)
- [Julia Mejia](https://github.com/juliamejia)
- [Cristian Rodriguez](https://github.com/CrisRod8)

## Mockups

Aquí presentamos algunos mockups de nuestro proyecto:
>
> ![image](https://github.com/santiforero1018/IETI-Project/assets/89321404/b5d48977-158e-495d-a5e2-fd5a6f1de5e0)
>
>![image](https://github.com/santiforero1018/IETI-Project/assets/89321404/542b3927-121d-4bf3-812e-f2d701d560cb)
>
>![image](https://github.com/santiforero1018/IETI-Project/assets/89321404/8e32cc95-7172-4be6-ab79-17b7e3078999)

## Despliegue local 

usando Docker, desplegamos de la siguiente manera, despues de clonar el repo

````bash
cd IETI-Project
````

despues de estar dentro de la carpeta del repositorio, ejecutamos los siguientes comandos que permitiran levantar
la aplicacion, primeramente, realizando la compilación del codigo.

````bash
mvn clean install
````

````bash
docker-compose build --no-cache
docker-compose up -d
````

## Apuntes

al realizar cambios en el codigo, toca borrar los contenedores compuestos y su información relacionada como los volumenes.
Para ello, se usa el siguiente comando:

````bash
docker-compose down --volumes --remove-orphans
````
y despues ejecutar los comandos anteriores para volver a desplegar en docker.


