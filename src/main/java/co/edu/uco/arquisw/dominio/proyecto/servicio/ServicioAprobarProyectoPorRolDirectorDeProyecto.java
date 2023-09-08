package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioEnviarCorreoElectronico;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

import javax.mail.MessagingException;

public class ServicioAprobarProyectoPorRolDirectorDeProyecto {
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final FaseRepositorioComando faseRepositorioComando;
    private final PostulacionRepositorioConsulta postulacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico;

    public ServicioAprobarProyectoPorRolDirectorDeProyecto(NecesidadRepositorioConsulta necesidadRepositorioConsulta, NecesidadRepositorioComando necesidadRepositorioComando, FaseRepositorioComando faseRepositorioComando, PostulacionRepositorioConsulta postulacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, ServicioEnviarCorreoElectronico servicioEnviarCorreoElectronico) {
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.faseRepositorioComando = faseRepositorioComando;
        this.postulacionRepositorioConsulta = postulacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.servicioEnviarCorreoElectronico = servicioEnviarCorreoElectronico;
    }

    public Long ejecutar(Long id, String token) {
        validarSiExisteProyectoConID(id);
        validarSiFueAprobadoPorRolLiderDeEquipo(id);

        var seleccionesDelProyecto = this.postulacionRepositorioConsulta.consultarSeleccionadosPorProyecto(id);
        var proyecto = this.necesidadRepositorioConsulta.consultarProyectoPorId(id);
        var aprobacionProyectoId = this.necesidadRepositorioComando.actualizarAprobacionProyecto(id, TextoConstante.ROL_DIRECTOR_PROYECTO);

        this.necesidadRepositorioComando.actualizarEstadoProyecto(EstadoProyecto.crear(TextoConstante.ESTADO_EN_DESARROLLO), id);
        this.faseRepositorioComando.guardar(id, token);

        seleccionesDelProyecto.forEach(seleccionDelProyecto -> {
            try {
                var correo = this.personaRepositorioConsulta.consultarPorId(seleccionDelProyecto.getUsuarioID()).getCorreo();
                var asunto = TextoConstante.PROYECTO_ACTUAL_APROBADO_POR_ROL_DIRECTOR_DE_PROYECTO;
                var cuerpo = TextoConstante.EL_PROYECTO + proyecto.getNombre() +  TextoConstante.HA_SIDO_APROBADO_POR_EL_ROL_DIRECTOR_DE_PROYECTO;

                this.servicioEnviarCorreoElectronico.enviarCorreo(correo, asunto, cuerpo);
            } catch (MessagingException e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        return aprobacionProyectoId;
    }

    private void validarSiExisteProyectoConID(Long id) {
        if(ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarProyectoPorId(id))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id);
        }
    }

    private void validarSiFueAprobadoPorRolLiderDeEquipo(Long id) {
        var proyectoDTO = this.necesidadRepositorioConsulta.consultarProyectoPorId(id);

        if(!proyectoDTO.getAprobacionProyecto().isLiderDeEquipo()) {
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_APROBAR_PROYECTO_SIN_LA_APROBACION_PREVIA_DEL_ROL_LIDER_DE_EQUIPO + id);
        }
    }
}
