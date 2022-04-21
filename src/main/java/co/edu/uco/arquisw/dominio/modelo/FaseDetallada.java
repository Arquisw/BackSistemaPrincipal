package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilNumero;
import co.edu.uco.arquisw.dominio.utilitario.UtilTexto;

public class FaseDetallada
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private int orden;

    private FaseDetallada(int codigo, String nombre, String descripcion, int orden)
    {
        this.codigo = codigo;
        setNombre(nombre);
        setDescripcion(descripcion);
        setOrden(orden);
    }

    public static FaseDetallada crear(int codigo, String nombre, String descripcion, int orden)
    {
        return new FaseDetallada(codigo, nombre, descripcion, orden);
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
        if(UtilTexto.cadenaEstaVacia(nombre))
        {
            new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(!UtilTexto.cadenaAlfanumerica(nombre))
        {
            new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!UtilTexto.longitudEsValida(nombre, 1, 50))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    private void setDescripcion(String descripcion)
    {
        if(UtilTexto.cadenaEstaVacia(descripcion))
        {
            new IllegalArgumentException("La descripcion no puede estar vacio");
        }

        if(!UtilTexto.cadenaAlfanumerica(descripcion))
        {
            new IllegalArgumentException("La descripcion solo puede contener letras y numeros");
        }

        if(!UtilTexto.longitudEsValida(descripcion, 1, 5000))
        {
            new IllegalArgumentException("La longitud de la descripcion debe estar entre 1 y 5000 caracteres");
        }

        this.descripcion = descripcion;
    }

    public int getOrden()
    {
        return orden;
    }

    private void setOrden(int orden)
    {
        if(UtilNumero.numeroEsMenorOIgual(orden, 0))
        {
            new IllegalArgumentException("El orden no puede ser menor o igual que cero");
        }

        this.orden = orden;
    }
}