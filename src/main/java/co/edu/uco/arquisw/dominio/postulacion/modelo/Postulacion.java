package co.edu.uco.arquisw.dominio.postulacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.formateador.FechaFormateador;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Postulacion
{
    private LocalDate fecha;
    private boolean seleccionado;

    public Postulacion(boolean seleccionado)
    {
        setFecha();
        setSeleccionado(seleccionado);
    }

    public void setFecha()
    {
        this.fecha = FechaFormateador.obtenerFechaActual();
    }

    public void setSeleccionado(boolean seleccionado)
    {
        this.seleccionado = seleccionado;
    }
}