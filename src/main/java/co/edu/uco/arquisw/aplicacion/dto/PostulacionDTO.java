package co.edu.uco.arquisw.aplicacion.dto;

import java.util.Date;

public class PostulacionDTO
{
    private int codigo;
    private Date fechaPostulacion;

    public PostulacionDTO()
    {

    }

    public PostulacionDTO(int codigo, Date fechaPostulacion)
    {
        this.codigo = codigo;
        this.fechaPostulacion = fechaPostulacion;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public Date getFechaPostulacion()
    {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion)
    {
        this.fechaPostulacion = fechaPostulacion;
    }
}
