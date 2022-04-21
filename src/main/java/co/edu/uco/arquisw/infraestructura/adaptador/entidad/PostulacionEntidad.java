package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postulacion")
public class PostulacionEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private Date fechaPostulacion;

    public PostulacionEntidad()
    {

    }

    public PostulacionEntidad(int codigo, Date fechaPostulacion)
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
