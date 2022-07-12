package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class EstadoNecesidad
{
    private String nombre;

    private EstadoNecesidad(String nombre)
    {
        setNombre(nombre);
    }

    public static EstadoNecesidad crear(String nombre)
    {
        return new EstadoNecesidad(nombre);
    }

    public void setNombre(String nombre)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_ESTADO_NECESIDAD_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronTextoEsValido(nombre, Mensajes.PATRON_NOMBRE_ESTADO_NECESIDAD_NO_ES_VALIDO);

        this.nombre = nombre;
    }
}