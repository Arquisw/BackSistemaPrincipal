package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioConsultarPersonaPorCorreo {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioConsultarPersonaPorCorreo(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(String correo)
    {
        validarSiNoExisteUsuarioConId(correo);

        return personaRepositorioConsulta.consultarPorCorreo(correo);
    }

    private void validarSiNoExisteUsuarioConId(String correo)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(correo)))
        {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + correo);
        }
    }
}
