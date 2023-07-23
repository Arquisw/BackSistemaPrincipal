package co.edu.uco.arquisw.dominio.usuario.servicio;

import javax.mail.MessagingException;

public interface ServicioEnviarCorreoElectronico {
    void enviarCorreo(String para, String asunto, String cuerpo) throws MessagingException;
}