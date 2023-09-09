package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarPersonaTest {
    @Test
    void validarSiExisteOtroUsuario() {

        var persona = new PersonaTestDataBuilder().build();
        var personaDto = new PersonaDTO();
        var clave = "ASDSFG2345h";

        var repositorioPersonaComando = Mockito.mock(PersonaRepositorioComando.class);
        var repositorioPersonaConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var servicioCifrarTexto = Mockito.mock(ServicioCifrarTexto.class);
        var servicioObtenerRoles = Mockito.mock(ServicioObtenerRoles.class);
        var servicio = new ServicioGuardarPersona(repositorioPersonaComando, repositorioPersonaConsulta, servicioCifrarTexto, servicioObtenerRoles);

        Mockito.when(repositorioPersonaConsulta.consultarPorCorreo((Mockito.anyString()))).thenReturn(personaDto);

        Assertions.assertEquals(Mensajes.EXISTE_USUARIO_CON_CORREO, Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutar(persona, clave)).getMessage());
    }
}