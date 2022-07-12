package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Necesidad
{
    private String rutaArchivo;
    private final EstadoNecesidad estado;
    private final Proyecto proyecto;

    public Necesidad(String rutaArchivo, EstadoNecesidad estado, Proyecto proyecto)
    {
        setRutaArchivo(rutaArchivo);
        this.estado = estado;
        this.proyecto = proyecto;
    }

    public static Necesidad crear(String rutaArchivo, EstadoNecesidad estado, Proyecto proyecto)
    {
        return new Necesidad(rutaArchivo, estado, proyecto);
    }

    public void setRutaArchivo(String rutaArchivo)
    {
        ValidarTexto.validarObligatorio(rutaArchivo, Mensajes.RUTA_ARCHIVO_NECESIDAD_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronURLEsValido(rutaArchivo, Mensajes.PATRON_RUTA_ARCHIVO_NECESIDAD_NO_ES_VALIDO);

        this.rutaArchivo = rutaArchivo;
    }
}