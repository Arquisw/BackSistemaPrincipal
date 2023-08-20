package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioAprobarProyectoPorRolIngenieria {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final ContratoRepositorioConsulta contratoRepositorioConsulta;

    public ServicioAprobarProyectoPorRolIngenieria(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, ContratoRepositorioConsulta contratoRepositorioConsulta) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.contratoRepositorioConsulta = contratoRepositorioConsulta;
    }

    public Long ejecutar(Long id) {
        validarSiExisteProyectoConID(id);
        validarSiElContratoFueEfectuado(id);

        return this.necesidadRepositorioComando.actualizarAprobacionProyecto(id, TextoConstante.ROL_INGENIERIA);
    }

    private void validarSiExisteProyectoConID(Long id) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }

    private void validarSiElContratoFueEfectuado(Long id) {
        if(!this.necesidadRepositorioConsulta.consultarPorProyectoId(id).getEstado().getNombre().equals(TextoConstante.ESTADO_NEGOCIADO)) {
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_APROBAR_PROYECTO_SIN_HABER_EFECTUADO_EL_CONTRATO + id);
        }
    }
}