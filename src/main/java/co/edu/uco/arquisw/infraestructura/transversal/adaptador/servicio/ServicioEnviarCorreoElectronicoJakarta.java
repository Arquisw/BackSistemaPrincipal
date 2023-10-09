package co.edu.uco.arquisw.infraestructura.transversal.adaptador.servicio;

import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class ServicioEnviarCorreoElectronicoJakarta implements ServicioEnviarCorreoElectronico {
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void enviarCorreo(String para, String asunto, String cuerpo) throws MailException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(TextoConstante.CORREO_PARA_NOTIFICAR);
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(cuerpo, true);

        mailSender.send(message);
    }
}