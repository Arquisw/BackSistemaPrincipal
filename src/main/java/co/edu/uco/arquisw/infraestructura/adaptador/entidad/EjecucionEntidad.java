package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import java.util.Date;

public class EjecucionEntidad
{
    private int codigo;
    private Date fechaInicio;
    private Date fechaFinal;
    private ProyectoEntidad proyecto;
    private PostulacionEntidad postulacion;

    public EjecucionEntidad()
    {

    }

    public EjecucionEntidad(int codigo, Date fechaInicio, Date fechaFinal, ProyectoEntidad proyecto, PostulacionEntidad postulacion)
    {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.proyecto = proyecto;
        this.postulacion = postulacion;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public ProyectoEntidad getProyecto()
    {
        return proyecto;
    }

    public void setProyecto(ProyectoEntidad proyecto)
    {
        this.proyecto = proyecto;
    }

    public PostulacionEntidad getPostulacion()
    {
        return postulacion;
    }

    public void setPostulacion(PostulacionEntidad postulacion)
    {
        this.postulacion = postulacion;
    }
}