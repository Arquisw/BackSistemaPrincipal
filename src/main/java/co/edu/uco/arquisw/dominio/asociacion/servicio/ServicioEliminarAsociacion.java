package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.consulta.NecesidadRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioEliminarAsociacion
{
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final NecesidadRepositorioConsulta necesidadRepositorioConsulta;

    public ServicioEliminarAsociacion(PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, NecesidadRepositorioConsulta necesidadRepositorioConsulta)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.necesidadRepositorioConsulta = necesidadRepositorioConsulta;
    }

    public Long ejecutar(Long id)
    {
        validarSiExisteUsuarioConID(id);
        validarSiPuedeEliminarLaCuenta(id);

        this.asociacionRepositorioComando.eliminar(id);

        return id;
    }

    private void validarSiPuedeEliminarLaCuenta(Long id)
    {
        var asociacion = this.asociacionRepositorioConsulta.consultarPorID(id);

        if(!ValidarObjeto.esNulo(this.necesidadRepositorioConsulta.consultarPorId(asociacion.getId())))
        {
            this.asociacionRepositorioComando.crearNotificacionEliminacion(asociacion.getId());
            throw new AutorizacionExcepcion(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_REGISTRADA);
        }
    }

    private void validarSiExisteUsuarioConID(Long id)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}