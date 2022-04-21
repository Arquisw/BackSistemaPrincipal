package co.edu.uco.arquisw.dominio.modelo;

import java.util.Date;

public class Ejecucion
{
    private int codigo;
    private Date fechaInicio;
    private Date fechaFinal;
    private Proyecto proyecto;
    private Postulacion postulacion;

    private Ejecucion(int codigo, Date fechaInicio, Date fechaFinal, Proyecto proyecto, Postulacion postulacion)
    {
        this.codigo = codigo;
        setFechaInicio(fechaInicio);
        setFechaFinal(fechaFinal);
        setProyecto(proyecto);
        setPostulacion(postulacion);
    }

    public static Ejecucion crear(int codigo, Date fechaInicio, Date fechaFinal, Proyecto proyecto, Postulacion postulacion)
    {
        return new Ejecucion(codigo, fechaInicio, fechaFinal, proyecto, postulacion);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    private void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    private void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public Proyecto getProyecto()
    {
        return proyecto;
    }

    private void setProyecto(Proyecto proyecto)
    {
        this.proyecto = proyecto;
    }

    public Postulacion getPostulacion()
    {
        return postulacion;
    }

    private void setPostulacion(Postulacion postulacion)
    {
        this.postulacion = postulacion;
    }
}