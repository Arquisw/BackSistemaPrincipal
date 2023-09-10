package co.edu.uco.arquisw.aplicacion.transversal.manejador;

import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

public interface ManejadorComandoVariableDeRutaRespuesta<C, L, R> {
    @Transactional
    R ejecutar(C comando, L id) throws MessagingException;
}