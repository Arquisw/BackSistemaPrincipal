package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.validador.ValidarTexto;

public class Asociacion
{
    private int codigo;
    private String nit;
    private String nombre;
    private EstadoAsociacion estado;
    private Necesidad necesidad;

    private Asociacion(int codigo, String nit, String nombre, EstadoAsociacion estado, Necesidad necesidad)
    {
        this.codigo = codigo;
        setNit(nit);
        setNombre(nombre);
        setEstado(estado);
        setNecesidad(necesidad);
    }

    public static Asociacion crear(int codigo, String nit, String nombre, EstadoAsociacion estado, Necesidad necesidad)
    {
        return new Asociacion(codigo, nit, nombre, estado, necesidad);
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
        if(ValidarTexto.cadenaEstaVacia(nit))
        {
            new IllegalArgumentException("El nit no puede estar vacio");
        }

        if(!ValidarTexto.cadenaNIT(nit))
        {
            new IllegalArgumentException("El nit debe cumplir el patron del nit");
        }

        if(!ValidarTexto.longitudEsValida(nit, 1, 2000))
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

    public EstadoAsociacion getEstado()
    {
        return estado;
    }

    private void setEstado(EstadoAsociacion estado)
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