# ms-gestion-viajes
Api para la gestion de viajes

El api esta desarrollado con spring webflux (bajo el paradigma de programacion reactiva).
Los endpoint implementados para el api son:

- Consultar la cantidad de viajes totales.
http://localhost:9092/viajes

- Consultar la cantidad de viajes totales por ciudad.
http://localhost:9092/viajes/ciudad/{ciudad}

- Consultar la cantidad de viajes totales por país.
http://localhost:9092/viajes/pais/{pais}

- Crear un viaje.
http://localhost:9092/viajes

- Actualizar un viaje.
http://localhost:9092/viajes/actualiza/{id}

- Consultar los viajes actuales
http://localhost:9092/viajes/actuales


El despliegue se efectúa mediante contenedores docker, mediante el archivo docker-compose.yml,
el cual tiene las instrucciones por Servicio:

- mongo: Obtiene la imagen de la base de datos de MongoDB
- mongo-carga: Efectua la carga incial del archivo json, con todas las colecciones (Trips.json) creando la coleccion Viajes
- api-springboot: Ejecuta el despliegue del microservicios referenciando a la base de datos creada y cargada

Para su ejecucion, posicionarse en la ruta root del proyecto y ejecutar:

1. docker-compose build

2. docker-compose up





