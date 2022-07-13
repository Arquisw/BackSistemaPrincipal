package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

import java.util.List;

public class ServicioConsultarPostulacionPorProyecto {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioConsultarPostulacionPorProyecto(PostulacionRepositorioConsulta postulacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }
    public List<PostulacionDTO> ejecutar(Long id)
    {
        validarSiExisteProyectoConID(id);

        return this.postulacionRepositorioConsulta.consultarPostulacionesPorProyecto(id);
    }
    private void validarSiExisteProyectoConID(Long id)
    {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }
}
