package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.validador.ValidarTexto;

public class TipoConsultoria
{
    private int codigo;
    private String nombre;

    private TipoConsultoria(int codigo, String nombre)
    {
        this.codigo = codigo;
        setNombre(nombre);
    }

    public static TipoConsultoria crear(int codigo, String nombre)
    {
        return new TipoConsultoria(codigo, nombre);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    private void setNombre(String nombre)
    {
        if(ValidarTexto.cadenaEstaVacia(nombre))
        {
            new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(!ValidarTexto.cadenaLetrasYEspacios(nombre))
        {
            new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(nombre, 1, 50))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }
}
