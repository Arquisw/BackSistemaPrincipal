package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import java.util.List;

public class ServicioConsultarSeleccionesPorUsuarioId {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioConsultarSeleccionesPorUsuarioId(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public List<SeleccionDTO> ejecutar(Long id) {
        validarSiExistePostulacionConUsuarioID(id);
        validarSiExistePostulacionConID(id);

        return this.postulacionRepositorioConsulta.consultarSeleccionesPorUsuarioId(id);
    }

    private void validarSiExistePostulacionConUsuarioID(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteUsuarioConId(id));
        }
    }

    private void validarSiExistePostulacionConID(Long id) {
        if (ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarSeleccionesPorUsuarioId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteSeleccionConId(id));
        }
    }
}