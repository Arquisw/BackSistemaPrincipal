package co.edu.uco.arquisw.dominio.postulacion.servicio;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioActualizarPostulacion {
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PostulacionRepositorioComando postulacionRepositorioComando;
    public ServicioActualizarPostulacion(PostulacionRepositorioConsulta postulacionRepositorioConsulta, PostulacionRepositorioComando postulacionRepositorioComando) {
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.postulacionRepositorioComando = postulacionRepositorioComando;

    }
    public Long ejecutar(Postulacion postulacion, Long id)
    {
        validarSiExistePostulacionConId(id);
        postulacion.seleccionarPostulante();
        Seleccion seleccion = Seleccion.crear();

        return this.postulacionRepositorioComando.actualizar(postulacion, seleccion, id);
    }
    private void validarSiExistePostulacionConId(Long id)
    {
        if(ValidarObjeto.esNulo(this.postulacionRepositorioConsulta.consultarSeleccionPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id);
        }
    }
}
