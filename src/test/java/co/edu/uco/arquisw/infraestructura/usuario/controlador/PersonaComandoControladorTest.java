package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.infraestructura.MyTestRequestFactory;
import co.edu.uco.arquisw.infraestructura.usuario.testdatabuilder.HojaDeVidaDtoTestDataBuilder;
import co.edu.uco.arquisw.infraestructura.usuario.testdatabuilder.PersonaDtoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class PersonaComandoControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void guardarPersona() throws Exception {
        var persona = new PersonaDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPost("/usuarios","ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void guardarPersonaFallida() throws Exception {
        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPost("/usuarios","ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void eliminacionPersonaPorAdministradorFallida() throws Exception {
        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/usuarios/administrador/{id}", id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("ValorInvalidoExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }

    @Test
    void eliminacionPersonaPorAdministradorExitosa() throws Exception {
        var id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/usuarios/administrador/{id}", id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/administrador/{id}", id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
    @Test
    void eliminacionPersonaExitosa() throws Exception {
        var id = 8;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/usuarios/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
    @Test
    void eliminacionPersonaFallidaPorTenerUnaAsociacion() throws Exception {
        var id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/usuarios/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("AutorizacionExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO)));
    }

    @Test
    void eliminacionPersonaFallida() throws Exception {
        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/usuarios/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("ValorInvalidoExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }
    @Test
    void deberiaActualizarPersona() throws Exception {

        Long id = 2L;
        var persona = new PersonaDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/usuarios/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk());
    }
    @Test
    void deberiaFallarAlActualizarPersona() throws Exception {

        Long id = 9L;
        var persona = new PersonaDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/usuarios/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }

    @Test
    void guardarHojaDeVida() throws Exception
    {
        var hojaDeVida = new HojaDeVidaDtoTestDataBuilder().build();

        var id = 3;
        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPostId("/usuarios/hojadevida/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(hojaDeVida)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void guardarHojaDeVidaPersonaFallida() throws Exception {

        var id = 10;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/usuarios/hojadevida/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("ValorInvalidoExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }
    @Test
    void deberiaActualizarHojaDeVida() throws Exception {

        Long id = 2L;
        var hojaDeVida = new HojaDeVidaDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/usuarios/hojadevida/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(hojaDeVida)))
                .andExpect(status().isOk());
    }
    @Test
    void deberiaFallarAlActualizarHojaDeVIDA() throws Exception {

        Long id = 9L;
        var hojaDeVida = new HojaDeVidaDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/usuarios/hojadevida/{id}", id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(hojaDeVida)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }
}
