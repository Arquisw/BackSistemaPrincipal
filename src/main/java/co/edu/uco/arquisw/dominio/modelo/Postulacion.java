package co.edu.uco.arquisw.dominio.modelo;

import java.time.LocalDate;

public class Postulacion
{
    private int codigo;
    private LocalDate fechaPostulacion;

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

    public LocalDate getFechaPostulacion()
    {
        return fechaPostulacion;
    }

    private void setFechaPostulacion()
    {
        this.fechaPostulacion = LocalDate.now();
    }
}
