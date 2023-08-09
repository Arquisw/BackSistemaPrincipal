package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarAsociacionPorIDUsuario {
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioConsultarAsociacionPorIDUsuario(AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public AsociacionDTO ejecutar(Long id) {
        validarSiExisteAsociacionConID(id);

        return this.asociacionRepositorioConsulta.consultarPorIDUsuario(id);
    }

    private void validarSiExisteAsociacionConID(Long id) {
        if(ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorIDUsuario(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id);
        }
    }
}