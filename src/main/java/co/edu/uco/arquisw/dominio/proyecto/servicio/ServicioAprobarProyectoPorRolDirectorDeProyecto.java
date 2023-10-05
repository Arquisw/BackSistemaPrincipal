package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.notificacion.factoria.ServicioNotificacionFactoria;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.NumeroConstante;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import static co.edu.uco.arquisw.dominio.transversal.enumerator.TipoNotificacion.PROYECTO_APROBADO_POR_ROL_DIRECTOR_DE_PROYECTO;

public class ServicioAprobarProyectoPorRolDirectorDeProyecto {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final FaseRepositorioComando faseRepositorioComando;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioNotificacionFactoria servicioNotificacionFactoria;

    public ServicioAprobarProyectoPorRolDirectorDeProyecto(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, FaseRepositorioComando faseRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioNotificacionFactoria servicioNotificacionFactoria) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.faseRepositorioComando = faseRepositorioComando;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioNotificacionFactoria = servicioNotificacionFactoria;
    }


    public Long ejecutar(Long id, String token) {
        validarSiExisteProyectoConID(id);
        validarSiFueAprobadoPorRolLiderDeEquipo(id);

        var seleccionesDelProyecto = this.postulacionRepositorioConsulta.consultarSeleccionadosPorProyecto(id);
        var proyecto = this.necesidadRepositorioConsulta.consultarProyectoPorId(id);
        var aprobacionProyectoId = this.necesidadRepositorioComando.actualizarAprobacionProyecto(id, TextoConstante.ROL_DIRECTOR_PROYECTO);

        this.necesidadRepositorioComando.actualizarEstadoProyecto(EstadoProyecto.crear(TextoConstante.ESTADO_EN_DESARROLLO), id);

        if(proyecto.getTiposConsultoria().stream().anyMatch(tipoConsultoria -> tipoConsultoria.getNombre().equals(TextoConstante.INGENIERIA_DE_REQUISITOS))) {
            this.faseRepositorioComando.guardar(id, token);
        }

        seleccionesDelProyecto.forEach(seleccionDelProyecto -> {
            var correo = this.personaRepositorioConsulta.consultarPorId(seleccionDelProyecto.getUsuarioID()).getCorreo();

            this.servicioNotificacionFactoria.orquestarNotificacion(
                    PROYECTO_APROBADO_POR_ROL_DIRECTOR_DE_PROYECTO,
                    id,
                    NumeroConstante.Zero,
                    NumeroConstante.Zero,
                    NumeroConstante.Zero,
                    TextoConstante.VACIO,
                    TextoConstante.VACIO,
                    correo,
                    seleccionDelProyecto
            );
        });

        return aprobacionProyectoId;
    }

    private void validarSiExisteProyectoConID(Long id) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }

    private void validarSiFueAprobadoPorRolLiderDeEquipo(Long id) {
        var proyectoDTO = this.necesidadRepositorioConsulta.consultarProyectoPorId(id);

        if (!proyectoDTO.getAprobacionProyecto().isLiderDeEquipo()) {
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_APROBAR_PROYECTO_SIN_LA_APROBACION_PREVIA_DEL_ROL_LIDER_DE_EQUIPO + id);
        }
    }
}