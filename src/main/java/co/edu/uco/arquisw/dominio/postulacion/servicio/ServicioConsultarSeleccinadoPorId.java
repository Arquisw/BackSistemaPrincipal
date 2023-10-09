package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarSeleccinadoPorId {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;

    public ServicioConsultarSeleccinadoPorId(PostulacionRepositorioConsulta postulacionRepositorioConsulta) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
    }

    public SeleccionDTO ejecutar(Long id) {
        validarSiExisteSeleccionConID(id);

        return this.postulacionRepositorioConsulta.consultarSeleccionPorId(id);
    }

    private void validarSiExisteSeleccionConID(Long id) {
        if (ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarSeleccionPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExistePostulacionConId(id));
        }
    }
}