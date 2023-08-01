package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Persona {
    private String nombre;
    private String apellidos;
    private String correo;

    private Persona(String nombre, String apellidos, String correo) {
        setNombre(nombre);
        setApellidos(apellidos);
        setCorreo(correo);
    }

    public static Persona crear(String nombre, String apellidos, String correo) {
        return new Persona(nombre, apellidos, correo);
    }

    private void setNombre(String nombre) {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_PERSONA_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(nombre, Mensajes.PATRON_NOMBRE_PERSONA_NO_ES_VALIDO);

        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        ValidarTexto.validarObligatorio(apellidos, Mensajes.APELLIDOS_PERSONA_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarPatronAlfanumericoEsValido(apellidos, Mensajes.PATRON_APELLIDOS_PERSONA_NO_ES_VALIDO);

        this.apellidos = apellidos;
    }

    private void setCorreo(String correo) {
        ValidarTexto.validarObligatorio(correo, Mensajes.CORREO_PERSONA_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarCorreoEsValido(correo, Mensajes.PATRON_CORREO_PERSONA_NO_ES_VALIDO);

        this.correo = correo;
    }
}