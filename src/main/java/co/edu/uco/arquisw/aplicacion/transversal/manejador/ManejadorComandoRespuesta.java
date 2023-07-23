package co.edu.uco.arquisw.aplicacion.transversal.manejador;

import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

public interface ManejadorComandoRespuesta<C, R> {
    @Transactional
    R ejecutar(C comando) throws MessagingException;
}