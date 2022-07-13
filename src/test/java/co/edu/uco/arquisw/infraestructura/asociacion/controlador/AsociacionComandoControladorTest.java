package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.ApplicationMock;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
        var idUsuario = 2;

        mocMvc.perform(MockMvcRequestBuilders.post("/asociaciones/{idUsuario}",idUsuario)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(asociacion)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void guardarAsociacionFallida() throws Exception
    {
        var idUsuario = 2;
        mocMvc.perform(MockMvcRequestBuilders.post("/asociaciones/{idUsuario}",idUsuario)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deberiaActualizarAsociacion() throws Exception{

        Long id = 2L;
        var asociacion = new AsociacionDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.put("/asociaciones/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(asociacion)))
                .andExpect(status().isOk());
    }
}
