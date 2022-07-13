package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Seleccion
{
    private LocalDate fecha;

    private Seleccion()
    {
        setFecha();
    }

    public static Seleccion crear()
    {
        return new Seleccion();
    }

    public void setFecha()
    {
        this.fecha = FechaFormateador.obtenerFechaActual();
    }
}