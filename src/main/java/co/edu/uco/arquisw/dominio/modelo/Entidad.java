package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilTexto;

public class Entidad
{
    private int codigo;
    private String nit;
    private String nombre;
    private EstadoEntidad estado;
    private Necesidad necesidad;

    private Entidad(int codigo, String nit, String nombre, EstadoEntidad estado, Necesidad necesidad)
    {
        this.codigo = codigo;
        setNit(nit);
        setNombre(nombre);
        setEstado(estado);
        setNecesidad(necesidad);
    }

    public static Entidad crear(int codigo, String nit, String nombre, EstadoEntidad estado, Necesidad necesidad)
    {
        return new Entidad(codigo, nit, nombre, estado, necesidad);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public String getNit()
    {
        return nit;
    }

    private void setNit(String nit)
    {
        if(UtilTexto.cadenaEstaVacia(nit))
        {
            new IllegalArgumentException("El nit no puede estar vacio");
        }

        if(!UtilTexto.cadenaNIT(nit))
        {
            new IllegalArgumentException("El nit debe cumplir el patron del nit");
        }

        if(!UtilTexto.longitudEsValida(nit, 1, 2000))
        {
            new IllegalArgumentException("La longitud del nit debe estar entre 1 y 2000 caracteres");
        }
        this.nit = nit;
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

        if(!UtilTexto.cadenaLetrasYEspacios(nombre))
        {
            new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!UtilTexto.longitudEsValida(nombre, 1, 50))
        {
            new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }

    public EstadoEntidad getEstado()
    {
        return estado;
    }

    private void setEstado(EstadoEntidad estado)
    {
        this.estado = estado;
    }

    public Necesidad getNecesidad()
    {
        return necesidad;
    }

    private void setNecesidad(Necesidad necesidad)
    {
        this.necesidad = necesidad;
    }
}