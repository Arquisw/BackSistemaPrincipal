package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilTexto;

public class Proyecto
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private EstadoProyecto estado;
    private FaseProyecto fase;
    private TipoConsultoria tipoConsultoria;

    private Proyecto(int codigo, String nombre, String descripcion, EstadoProyecto estado, FaseProyecto fase, TipoConsultoria tipoConsultoria)
    {
        this.codigo = codigo;
        setNombre(nombre);
        setDescripcion(descripcion);
        setEstado(estado);
        setFase(fase);
        setTipoConsultoria(tipoConsultoria);
    }

    public static Proyecto crear(int codigo, String nombre, String descripcion, EstadoProyecto estado, FaseProyecto fase, TipoConsultoria tipoConsultoria)
    {
        return new Proyecto(codigo, nombre, descripcion, estado, fase, tipoConsultoria);
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

    public EstadoProyecto getEstado()
    {
        return estado;
    }

    private void setEstado(EstadoProyecto estado)
    {
        this.estado = estado;
    }

    public FaseProyecto getFase()
    {
        return fase;
    }

    private void setFase(FaseProyecto fase)
    {
        this.fase = fase;
    }

    public TipoConsultoria getTipoConsultoria()
    {
        return tipoConsultoria;
    }

    private void setTipoConsultoria(TipoConsultoria tipoConsultoria)
    {
        this.tipoConsultoria = tipoConsultoria;
    }
}