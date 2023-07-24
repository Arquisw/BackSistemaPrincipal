package co.edu.uco.arquisw.infraestructura.usuario.adaptador.servicio;

import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioEnviarCorreoElectronico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class ServicioEnviarCorreoElectronicoJakarta implements ServicioEnviarCorreoElectronico {
    private static final String CORREO = "arquisoftwareuco@outlook.com";
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void enviarCorreo(String para, String asunto, String cuerpo) throws MailException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(CORREO);
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(cuerpo, true);

        mailSender.send(message);
    }
}