package co.edu.uco.arquisw.aplicacion.transversal.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface Manejador {
    @Transactional
    void ejecutar();
}