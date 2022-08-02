package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioGuardarAsociacion
{
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioGuardarAsociacion(AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Asociacion asociacion, Long usuarioID)
    {
        validarSiExisteAsociacionConNIT(asociacion.getNit());
        validarSiExisteUsuarioConID(usuarioID);

        return this.asociacionRepositorioComando.guardar(asociacion, usuarioID);
    }

    private void validarSiExisteUsuarioConID(Long usuarioID)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(usuarioID)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + usuarioID);
        }
    }

    private void validarSiExisteAsociacionConNIT(String nit)
    {
        if(!ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorNIT(nit)))
        {
            throw new DuplicidadExcepcion(Mensajes.EXISTE_ASOCIACION_CON_NIT + nit);
        }
    }
}
