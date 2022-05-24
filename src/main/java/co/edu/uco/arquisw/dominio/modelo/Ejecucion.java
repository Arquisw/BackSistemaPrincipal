package co.edu.uco.arquisw.dominio.modelo;

import java.time.LocalDate;

public class Ejecucion
{
    private int codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private Proyecto proyecto;
    private Postulacion postulacion;

    private Ejecucion(int codigo, LocalDate fechaInicio, LocalDate fechaFinal, Proyecto proyecto, Postulacion postulacion)
    {
        this.codigo = codigo;
        setFechaInicio(fechaInicio);
        setFechaFinal(fechaFinal);
        setProyecto(proyecto);
        setPostulacion(postulacion);
    }

    public static Ejecucion crear(int codigo, LocalDate fechaInicio, LocalDate fechaFinal, Proyecto proyecto, Postulacion postulacion)
    {
        return new Ejecucion(codigo, fechaInicio, fechaFinal, proyecto, postulacion);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public LocalDate getFechaInicio()
    {
        return fechaInicio;
    }

    private void setFechaInicio(LocalDate fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal()
    {
        return fechaFinal;
    }

    private void setFechaFinal(LocalDate fechaFinal)
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