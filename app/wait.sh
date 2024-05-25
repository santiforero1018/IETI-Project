#!/bin/bash

while ! nc -z db 3306; do
  echo "Esperando a que el servicio de base de datos esté disponible..."
  sleep 1
done

java -jar project-0.0.1-SNAPSHOT.jar