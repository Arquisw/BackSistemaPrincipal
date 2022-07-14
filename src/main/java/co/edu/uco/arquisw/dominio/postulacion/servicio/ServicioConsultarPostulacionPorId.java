package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarPostulacionPorId
{
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;

    public ServicioConsultarPostulacionPorId(PostulacionRepositorioConsulta postulacionRepositorioConsulta) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
    }

    public PostulacionDTO ejecutar(Long id)
    {
        validarSiExistePostulacionConID(id);
        return this.postulacionRepositorioConsulta.consultarPostulacionPorId(id);
    }
    private void validarSiExistePostulacionConID(Long id)
    {
        if(ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarPostulacionPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}
