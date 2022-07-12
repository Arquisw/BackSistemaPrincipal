package co.edu.uco.arquisw.aplicacion.transversal.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoActualizacionRespuesta<C, L, R>
{
    @Transactional
    R ejecutar(C comando, L id);
}