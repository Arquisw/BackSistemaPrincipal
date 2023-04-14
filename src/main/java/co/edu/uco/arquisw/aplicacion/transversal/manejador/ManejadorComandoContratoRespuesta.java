package co.edu.uco.arquisw.aplicacion.transversal.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoContratoRespuesta<C, L, T, R> {
    @Transactional
    R ejecutar(C comando, L id, T token);
}