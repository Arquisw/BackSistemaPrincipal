package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.infraestructura.MyTestRequestFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@ImportResource
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PersonaConsultaControladorTest
{
    @Autowired
    private MockMvc mocMvc;

    @Test
    void obtenerPersonasExitosa() throws Exception
    {
        var  id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("eduardo")))
                .andExpect(jsonPath("$.apellidos", is("Marulete")))
                .andExpect(jsonPath("$.correo", is("marulete@gmail.com")));
    }

    @Test
    void obtenerPeticionesPorAdministradorExitosa() throws Exception
    {
        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGet("/usuarios/administrador","ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void obtenerPorAdministadorFalla() throws Exception
    {
        var id = 10;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("ValorInvalidoExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }

    @Test
    void obtenerHojaDeVidaPorIdFallido() throws Exception
    {
        var  id = 10;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/hojadevida/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("ValorInvalidoExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }

    @Test
    void obtenerHojaDeVidaExitosa() throws Exception
    {
        var  id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/hojadevida/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ruta", is("http://www.direccion.org/ejemploCV/item.html")));
    }
}
