package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioUsuarioEsPropetarioDelProyecto {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioUsuarioEsPropetarioDelProyecto(PersonaRepositorioConsulta personaRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public Boolean ejecutar(Long necesidadId, Long usuarioId) {
        validarSiExisteNecesidadConId(necesidadId);
        validarSiExisteUsuarioConId(usuarioId);

        var necesidad = this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadId);
        var asociacion = this.asociacionRepositorioConsulta.consultarPorIDUsuario(usuarioId);

        if (necesidad.getAsociacion().equals(asociacion.getId())) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private void validarSiExisteNecesidadConId(Long necesidadId) {
        if (ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorNecesidadId(necesidadId))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + necesidadId);
        }
    }

    private void validarSiExisteUsuarioConId(Long usuarioId) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(usuarioId))) {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + usuarioId);
        }
    }
}