package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.AprobacionProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarAprobacionProyectoPorId {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarAprobacionProyectoPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public AprobacionProyectoDTO ejecutar(Long id) {
        validarSiExisteProyectoConID(id);

        return this.necesidadRepositorioConsulta.consultarAprobacionProyectoPorId(id);
    }

    private void validarSiExisteProyectoConID(Long id) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }
}
