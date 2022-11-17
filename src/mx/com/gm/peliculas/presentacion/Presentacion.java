package mx.com.gm.peliculas.presentacion;

import mx.com.gm.peliculas.negocio.*;

import java.util.Scanner;

public class Presentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        while(opcion != 0){
            System.out.println("Elige una opción: \n" +
                    "1. Iniciar Catalogo de peliculas \n" +
                    "2. Agregar Pelicula \n" +
                    "3. Listar Peliculas \n" +
                    "4. Buscar Pelicula \n" +
                    "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Proporciona el nombre de la pelicula a agregar:");
                    catalogo.agregarPelicula(scanner.nextLine());
                    break;
                case 3:
                    catalogo.listarPeiculas();
                    break;
                case 4:
                    System.out.println("Que pelicula quieres buscar?: ");
                    catalogo.buscarPelicula(scanner.nextLine());
                    break;
                case 0:
                    System.out.println("Nos vemos!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
    }
}
