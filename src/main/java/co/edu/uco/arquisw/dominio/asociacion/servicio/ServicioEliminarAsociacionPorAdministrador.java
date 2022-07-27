package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioEliminarAsociacionPorAdministrador
{
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final PersonaRepositorioComando personaRepositorioComando;

    public ServicioEliminarAsociacionPorAdministrador(PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioComando asociacionRepositorioComando, PersonaRepositorioComando personaRepositorioComando)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.personaRepositorioComando = personaRepositorioComando;
    }

    public Long ejecutar(Long id)
    {
        validarSiExisteUsuarioConID(id);

        this.asociacionRepositorioComando.eliminar(id);

        var rol = Rol.crear(TextoConstante.ROL_ASOCIACION);

        this.personaRepositorioComando.eliminarRol(rol, id);

        return id;
    }

    private void validarSiExisteUsuarioConID(Long id)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}