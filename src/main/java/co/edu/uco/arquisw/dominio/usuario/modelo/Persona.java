package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@Getter
public class Persona {
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;
    private List<Rol> roles;

    private Persona(String nombre, String apellidos, String correo, String clave, List<Rol> roles) {
        setNombre(nombre);
        setApellidos(apellidos);
        setCorreo(correo);
        setClave(clave);
        setRoles(roles);
    }

    public static Persona crear(String nombre, String apellidos, String correo, String clave, List<Rol> roles) {
        return new Persona(nombre, apellidos, correo, clave, roles);
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

    public void setClave(String clave) {
        ValidarTexto.validarObligatorio(clave, Mensajes.CLAVE_PERSONA_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarClaveEsValida(clave, Mensajes.PATRON_CLAVE_PERSONA_NO_ES_VALIDO);
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        this.clave = passwordEncoder.encode(clave);
    }

    private void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}