package co.edu.uco.arquisw.aplicacion.dto;

import java.util.Date;

public class EjecucionDTO
{
    private int codigo;
    private Date fechaInicio;
    private Date fechaFinal;
    private ProyectoDTO proyecto;
    private PostulacionDTO postulacion;

    public EjecucionDTO()
    {

    }

    public EjecucionDTO(int codigo, Date fechaInicio, Date fechaFinal, ProyectoDTO proyecto, PostulacionDTO postulacion)
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

    public ProyectoDTO getProyecto()
    {
        return proyecto;
    }

    public void setProyecto(ProyectoDTO proyecto)
    {
        this.proyecto = proyecto;
    }

    public PostulacionDTO getPostulacion()
    {
        return postulacion;
    }

    public void setPostulacion(PostulacionDTO postulacion)
    {
        this.postulacion = postulacion;
    }
}