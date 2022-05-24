package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.validador.ValidarTexto;

public class Comentario
{
    private int codigo;
    private String descripcion;

    private Comentario(int codigo, String descripcion)
    {
        this.codigo = codigo;
        setDescripcion(descripcion);
    }

    public static Comentario crear(int codigo, String descripcion)
    {
        return new Comentario(codigo, descripcion);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    private void setDescripcion(String descripcion)
    {
        if(ValidarTexto.cadenaEstaVacia(descripcion))
        {
            new IllegalArgumentException("La descripcion no puede estar vacio");
        }

        if(!ValidarTexto.cadenaAlfanumerica(descripcion))
        {
            new IllegalArgumentException("La descripcion solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(descripcion, 1, 5000))
        {
            new IllegalArgumentException("La longitud de la descripcion debe estar entre 1 y 5000 caracteres");
        }

        this.descripcion = descripcion;
    }
}