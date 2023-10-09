package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioActualizarRolPorAdministrador {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioActualizarRolPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(boolean leer, boolean escribir, boolean actualizar, boolean eliminar, Long id) {
        validarSiNoExisteRolConId(id);

        return this.personaRepositorioComando.actualizarRol(leer, escribir, actualizar, eliminar, id);
    }

    private void validarSiNoExisteRolConId(Long id) {
        if (ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarRolPorId(id))) {
            throw new NullPointerException(Mensajes.obtenerNoExisteRolConId(id));
        }
    }
}