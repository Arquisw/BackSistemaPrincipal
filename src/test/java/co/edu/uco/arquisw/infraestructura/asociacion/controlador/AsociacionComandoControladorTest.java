package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.infraestructura.MyTestRequestFactory;
import co.edu.uco.arquisw.infraestructura.asociacion.testdatabuilder.AsociacionDtoTestDataBuilder;
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
class AsociacionComandoControladorTest
{
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void guardarAsociacion() throws Exception {

        var asociacion = new AsociacionDtoTestDataBuilder().build();
        var idUsuario = 8;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPostId("/asociaciones/{idUsuario}", idUsuario)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(asociacion)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void guardarAsociacionFallida() throws Exception
    {
        var idUsuario = 2;
        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPostId("/asociaciones/{idUsuario}",idUsuario)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deberiaActualizarAsociacion() throws Exception{

        Long id = 2L;
        var asociacion = new AsociacionDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/asociaciones/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(asociacion)))
                .andExpect(status().isOk());
    }
    @Test
    void deberiaFallarAlActualizarAsociacion() throws Exception {

        Long id = 9L;
        var asociacion = new AsociacionDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/asociaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(asociacion)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id)));
    }
    @Test
    void eliminacionAsociacionFallida() throws Exception {
        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/asociaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));
    }
    @Test
    void eliminacionAsociacionFallidaPorTenerNecesidarRegistrada() throws Exception {
        var id = 4;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/asociaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("AutorizacionExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_REGISTRADA)));
    }
    @Test
    void eliminacionNecesidadAdministradorFallida() throws Exception {
        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/necesidades/administrador/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id)));
    }
}
