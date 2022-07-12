package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Rol
{
    private String nombre;

    private Rol(String nombre)
    {
        setNombre(nombre);
    }

    public static Rol crear(String nombre)
    {
        return new Rol(nombre);
    }

    private void setNombre(String nombre)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_ROL_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(nombre, Mensajes.PATRON_NOMBRE_ROL_INVALIDO);

        this.nombre = nombre;
    }
}