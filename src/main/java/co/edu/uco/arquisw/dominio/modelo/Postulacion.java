package co.edu.uco.arquisw.dominio.modelo;

import co.edu.uco.arquisw.dominio.utilitario.UtilFecha;
import java.util.Date;

public class Postulacion
{
    private int codigo;
    private Date fechaPostulacion;

    private Postulacion(int codigo)
    {
        this.codigo = codigo;
        setFechaPostulacion();
    }

    public static Postulacion crear(int codigo)
    {
        return new Postulacion(codigo);
    }

    public int getCodigo()
    {
        return codigo;
    }

    public Date getFechaPostulacion()
    {
        return fechaPostulacion;
    }

    private void setFechaPostulacion()
    {
        this.fechaPostulacion = UtilFecha.obtenerFechaActual();
    }
}
