package presentacion;


import dominio.Pelicula;
import service.IServicioPeliculas;
import service.ServicioListaPeliculas;
import service.ServicioPeliculasFile;

import java.util.Scanner;

public class ColeccionPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola  = new Scanner(System.in);
        //Agregamos la implementacion del servicio
        //IServicioPeliculas servicioPeliculas = new ServicioListaPeliculas();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasFile();
        while(!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                ****Coleccion de Peliculas****
                1. Agregar Pelicula
                2. Listar Peliculas
                3. Buscar Peliculas
                4. Salir
                Elige una opcion:
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            IServicioPeliculas servicioPeliculas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 ->{
                System.out.print("Nombre de Pelicula: ");
                var nombre = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombre));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 -> {
                System.out.println("Introduce la Pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto.");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida. " + opcion);
        }
        return salir;
    }
}