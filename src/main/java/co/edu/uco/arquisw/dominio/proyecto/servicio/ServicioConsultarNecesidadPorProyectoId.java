package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.NecesidadDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarNecesidadPorProyectoId {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarNecesidadPorProyectoId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public NecesidadDTO ejecutar(Long id) {
        validarSiExisteProyectoConID(id);

        return this.necesidadRepositorioConsulta.consultarPorProyectoId(id);
    }

    private void validarSiExisteProyectoConID(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }
}