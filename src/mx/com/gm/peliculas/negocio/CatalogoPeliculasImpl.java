package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
    private final IAccesoDatos datos;


    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombre){
        var pelicula = new Pelicula(nombre);
        boolean anexar = false;
        try{
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        }catch (AccesoDatosEx accesoDatosEx) {
            accesoDatosEx.printStackTrace();
        }

    }

    @Override
    public void listarPeiculas() {
        try{
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula: peliculas) {
                System.out.println("Pelicula: " + pelicula);
            }
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
        }


    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try{
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
        }
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public void iniciarArchivo() {
        try{
            if(this.datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }else{
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx accesoDatosEx) {
            accesoDatosEx.printStackTrace();
        }
    }
}
