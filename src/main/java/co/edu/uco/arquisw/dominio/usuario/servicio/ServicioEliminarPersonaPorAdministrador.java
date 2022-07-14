package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioEliminarPersonaPorAdministrador
{
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioEliminarPersonaPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Long id)
    {
        validarSiNoExisteUsuarioConId(id);

        this.personaRepositorioComando.eliminar(id);

        return id;
    }

    private void validarSiNoExisteUsuarioConId(Long id)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id)))
        {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}