# Listado de Películas en Java

Este proyecto es una aplicación de consola en Java que permite gestionar una colección de películas. La aplicación permite agregar, listar y buscar películas, utilizando una interfaz de servicio que puede trabajar tanto con una lista en memoria como con un archivo de texto.

## Características

- Interfaz de consola amigable.
- Manejo de excepciones para entradas inválidas.
- Menú de opciones para agregar, listar y buscar películas.
- Uso de una interfaz de servicio para abstraer la lógica de almacenamiento.
- Implementación de servicios para almacenar películas en una lista y en un archivo de texto.

## Tecnologías Utilizadas

- Java
- ArrayList para almacenar los datos de las películas en memoria.
- File I/O para almacenar los datos de las películas en un archivo de texto.

## Instrucciones de Uso

1. Clona el repositorio:

    ```bash
    git clone https://github.com/gianpoker1/Coleccion-Peliculas.git
    cd ColeccionPeliculasApp
    ```

2. Compila los archivos Java:

    ```bash
    javac dominio/Pelicula.java service/IServicioPeliculas.java service/ServicioListaPeliculas.java service/ServicioPeliculasFile.java presentacion/ColeccionPeliculasApp.java
    ```

3. Ejecuta el programa:

    ```bash
    java presentacion.ColeccionPeliculasApp
    ```

## Estructura del Proyecto

- `dominio/Pelicula.java`: Clase que representa una película.
- `service/IServicioPeliculas.java`: Interfaz que define los métodos para gestionar películas.
- `service/ServicioListaPeliculas.java`: Implementación de la interfaz que utiliza una lista en memoria.
- `service/ServicioPeliculasFile.java`: Implementación de la interfaz que utiliza un archivo de texto.
- `presentacion/ColeccionPeliculasApp.java`: Clase principal que contiene el menú y la lógica para interactuar con el usuario.

## Ejemplo de Uso

Coleccion de Peliculas

1. **Agregar Pelicula**
   
2. **Listar Peliculas**
   
3. **Buscar Peliculas**
   
4. **Salir**

**Elige una opcion:** 
```1 

Nombre de Pelicula: Batman 

Se añadio la pelicula Batman
```

**Coleccion de Peliculas**

1. **Agregar Pelicula**
   
2. **Listar Peliculas**
   
3. **Buscar Peliculas**
   
4. **Salir**

**Elige una opcion:** ```2 

Lista de Peliculas: Batman
```

**Coleccion de Peliculas**

1. **Agregar Pelicula**
   
2. **Listar Peliculas**
   
3. **Buscar Peliculas**
   
4. **Salir**

**Elige una opcion:** ```3 

**Introduce la Pelicula a buscar:** Batman 

Pelicula Batman encontrada - linea 1
```
