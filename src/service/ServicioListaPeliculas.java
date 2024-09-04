package service;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioListaPeliculas implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioListaPeliculas(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Lista de Peliculas: ");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se añadio la pelicula " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Retorna el indice de la pelicula en la lista
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1){
            System.out.println("No se encontro la pelicula: " + pelicula);
        }else {
            ++indice;
            System.out.println("Pelicula encontrada en el indice: " + indice);
        }
    }

    public static void main(String[] args) {
        //creamos objetos de pelicula
        var pelicula1 = new Pelicula("batman");
        var pelicula2 = new Pelicula("Superman");
        //creamos el servicio (patron de diseño service)
        IServicioPeliculas servicoPeliculas = new ServicioListaPeliculas();
        //agregamos las peliculas a la lista
        servicoPeliculas.agregarPelicula(pelicula1);
        servicoPeliculas.agregarPelicula(pelicula2);
        servicoPeliculas.listarPeliculas();

        //buscamos una pelicula
        //se debe implemente metodos equals y hashCode
        servicoPeliculas.buscarPelicula(pelicula1);
    }
}
