package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.proyecto.dto.ProyectoDTO;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarProyectoPorId
{
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;


    public ServicioConsultarProyectoPorId(NecesidadRepositorioConsulta necesidadRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public ProyectoDTO ejecutar(Long id)
    {
        validarSiExisteProyectoConID(id);

        return this.necesidadRepositorioConsulta.consultarProyectoPorId(id);
    }

    private void validarSiExisteProyectoConID(Long id)
    {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }
}
