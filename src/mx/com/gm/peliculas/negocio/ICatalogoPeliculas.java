package mx.com.gm.peliculas.negocio;

public interface ICatalogoPeliculas {

    String NOMBRE_ARCHIVO = "peliculas.txt";

    void agregarPelicula(String nombre);

    void listarPeiculas();

    void buscarPelicula(String buscar);

    void iniciarArchivo();

}
