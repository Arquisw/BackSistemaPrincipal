package co.edu.uco.arquisw.infraestructura.contrato.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.infraestructura.MyTestRequestFactory;
import co.edu.uco.arquisw.infraestructura.contrato.testdatabuilder.ContratoDtoTestDataBuilder;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@ImportResource
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ContratoComandoControladorTest
{
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void guardarAsociacionFallida() throws Exception
    {
        var idAsociacion = 5;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPostId("/contratos/{id}",idAsociacion,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deberiaActualizarContrato() throws Exception
    {
        Long id = 3L;

        var contrato = new ContratoDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/contratos/{id}",id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contrato)))
                .andExpect(status().isOk());
    }

    @Test
    void deberiaActualizarContratoFallido() throws Exception
    {
        Long id = 6L;

        var contrato = new ContratoDtoTestDataBuilder().build();

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedPut("/contratos/{id}",id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contrato)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void eliminacionContratoFallido() throws Exception
    {
        var id = 6L;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedDelete("/contratos/{id}", (int)id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}