package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class TipoConsultoria
{
    private String nombre;

    private TipoConsultoria(String nombre)
    {
        setNombre(nombre);
    }

    public static TipoConsultoria crear(String nombre)
    {
        return new TipoConsultoria(nombre);
    }

    public void setNombre(String nombre)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_TIPO_CONSULTORIA_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronTextoEsValido(nombre, Mensajes.PATRON_NOMBRE_TIPO_CONSULTORIA_NO_ES_VALIDO);

        this.nombre = nombre;
    }
}