package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import java.util.List;

public class ServicioConsultarSeleccionadoPorProyecto {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarSeleccionadoPorProyecto(PostulacionRepositorioConsulta postulacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public List<SeleccionDTO> ejecutar(Long proyectoID) {
        validarSiExisteProyectoConId(proyectoID);

        return this.postulacionRepositorioConsulta.consultarSeleccionadosPorProyecto(proyectoID);
    }

    private void validarSiExisteProyectoConId(Long proyectoID) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(proyectoID))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + proyectoID);
        }
    }
}