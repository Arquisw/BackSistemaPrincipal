package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Postulacion
{
    private LocalDate fecha;
    private boolean seleccionado;

    private Postulacion(boolean seleccionado)
    {
        setFecha();
        setSeleccionado(seleccionado);
    }

    public static Postulacion crear(boolean seleccionado)
    {
        return new Postulacion(seleccionado);
    }

    private void setFecha()
    {
        this.fecha = FechaFormateador.obtenerFechaActual();
    }

    private void setSeleccionado(boolean seleccionado)
    {
        this.seleccionado = seleccionado;
    }
}