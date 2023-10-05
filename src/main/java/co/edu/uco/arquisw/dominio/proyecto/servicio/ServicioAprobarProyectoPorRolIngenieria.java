package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import static co.edu.uco.arquisw.dominio.transversal.enumerator.TipoNotificacion.PROYECTO_APROBADO_POR_ROL_INGENIERIA;

public class ServicioAprobarProyectoPorRolIngenieria {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public ServicioAprobarProyectoPorRolIngenieria(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioNotificacionFactoria = servicioNotificacionFactoria;
    }


    public Long ejecutar(Long id) {
        validarSiExisteProyectoConID(id);
        validarSiElContratoFueEfectuado(id);

        var seleccionesDelProyecto = this.postulacionRepositorioConsulta.consultarSeleccionadosPorProyecto(id);

        var aprobacionId = this.necesidadRepositorioComando.actualizarAprobacionProyecto(id, TextoConstante.ROL_INGENIERIA);

        seleccionesDelProyecto.forEach(seleccionDelProyecto -> {
            if (seleccionDelProyecto.getRoles().contains(TextoConstante.ROL_LIDER_DEL_EQUIPO)) {
                var correo = this.personaRepositorioConsulta.consultarPorId(seleccionDelProyecto.getUsuarioID()).getCorreo();

                this.servicioNotificacionFactoria.orquestarNotificacion(
                        PROYECTO_APROBADO_POR_ROL_INGENIERIA,
                        id,
                        NumeroConstante.Zero,
                        NumeroConstante.Zero,
                        NumeroConstante.Zero,
                        TextoConstante.VACIO,
                        TextoConstante.VACIO,
                        correo,
                        seleccionDelProyecto
                );
            }
        });

        return aprobacionId;
    }

    private void validarSiExisteProyectoConID(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }

    private void validarSiElContratoFueEfectuado(Long id) {
        if (!this.necesidadRepositorioConsulta.consultarPorProyectoId(id).getEstado().getNombre().equals(TextoConstante.ESTADO_NEGOCIADO)) {
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_APROBAR_PROYECTO_SIN_HABER_EFECTUADO_EL_CONTRATO + id);
        }
    }
}