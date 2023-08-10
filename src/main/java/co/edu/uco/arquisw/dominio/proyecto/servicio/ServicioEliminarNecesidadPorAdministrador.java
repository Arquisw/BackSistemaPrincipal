package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioEliminarNecesidadPorAdministrador {
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;

    public ServicioEliminarNecesidadPorAdministrador(AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando) {
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
    }


    public Long ejecutar(Long id) {
        validarSiExisteAsociacionConID(id);

        this.necesidadRepositorioComando.eliminarPorAdministrador(id);

        return id;
    }

    private void validarSiExisteAsociacionConID(Long id) {
        if(ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id);
        }
    }
}