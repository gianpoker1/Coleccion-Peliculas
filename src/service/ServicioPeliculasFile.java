package service;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasFile implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasFile() {
        var fichero = new File(NOMBRE_ARCHIVO);
        try{
            //si existe, no lo volvemos a crear
            if(fichero.exists()){
                System.out.println("El fichero ya existe");
            }else {
                //Se crea el fichero
                var salida = new PrintWriter(new FileWriter(fichero));
                salida.close();
                System.out.println("Fichero creado correctamente.");
            }

        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el fichero: " + e.getMessage());
        }
    }



    @Override
    public void listarPeliculas() {
        //abrimos fichero
        var fichero = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de peliculas");
            //abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(fichero));
            //leemos linea a linea
            String linea;
            linea = entrada.readLine();
            //leemos todas las lineas
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //antes de terminar el ciclo, leemos la siguiente linea
                linea = entrada.readLine();
            }
            //cerrar el fichero
            entrada.close();

        }catch (Exception e){
            System.out.println("Ocurrio un error el leer el fichero: " + e.getMessage());
        }

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

        boolean anexar = false;
        var fichero = new File(NOMBRE_ARCHIVO);
        try {
            //comprobamos si existe el fichero
            anexar = fichero.exists();
            var salida = new PrintWriter(new FileWriter(fichero, anexar));
            //Agregamos la pelicula (pelicula.toString())
            salida.println(pelicula);
            salida.close();
            System.out.println("Se añadio pelicula correctamente.");
        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula: " +e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var fichero = new File(NOMBRE_ARCHIVO);
        try {
            //abrimos el fichero para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(fichero));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaABuscar = pelicula.getNombre();
            while(lineaTexto != null){
                //buscar independiente de mayus/minus
                if(peliculaABuscar != null && peliculaABuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //leemos la siguiente linea antes de la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;
            }
            //imprimos los resultados de la busqueda
            if(encontrada){
                System.out.println("Pelicula " + lineaTexto + " encontrada - linea "
                        + indice);
            }else{
                System.out.println("no se encontro la pelicula: " + pelicula.getNombre());
            }
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar: " + e.getMessage());
        }

    }
}
