package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class Usuario {
    private String correo;
    private String clave;

    private Usuario(String correo, String clave) {
        setCorreo(correo);
        setClave(clave);
    }

    public static Usuario crear(String correo, String clave) {
        return new Usuario(correo, clave);
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
}