package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.validador.ValidarTexto;

public class Contrato
{
    private int codigo;
    private String urlArchivo;

    private Contrato(int codigo, String nombre)
    {
        this.codigo = codigo;
        setUrlArchivo(nombre);
    }

    public static Contrato crear(int codigo, String nombre)
    {
        return new Contrato(codigo, nombre);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public String getUrlArchivo()
    {
        return urlArchivo;
    }

    private void setUrlArchivo(String urlArchivo)
    {
        if(ValidarTexto.cadenaEstaVacia(urlArchivo))
        {
            new IllegalArgumentException("El urlArchivo no puede estar vacio");
        }

        if(!ValidarTexto.cadenaURL(urlArchivo))
        {
            new IllegalArgumentException("El urlArchivo debe cumplir el patron el url");
        }

        if(!ValidarTexto.longitudEsValida(urlArchivo, 1, 2000))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 2000 caracteres");
        }

        this.urlArchivo = urlArchivo;
    }
}
