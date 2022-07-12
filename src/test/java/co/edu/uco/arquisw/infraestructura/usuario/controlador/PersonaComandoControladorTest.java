package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.infraestructura.usuario.testdatabuilder.PersonaDtoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
public class PersonaComandoControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Test
    void guardarPersona() throws Exception {
        var persona = new PersonaDtoTestDataBuilder().build();

         mocMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        Assertions.assertNotNull(1);

    }
    @Test
    void guardarUsuarioFallida() throws Exception
    {
        mocMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void eliminacionUsuarioFallida() throws Exception
    {
        var  id = 3;

        mocMvc.perform(MockMvcRequestBuilders.delete("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("ValorInvalidoExcepcion")))
                .andExpect(jsonPath("$.mensaje", is("No existe un usuario con el id " + id)));
    }
    @Test
    void eliminacionExitosa() throws Exception
    {
        var  id = 2;

        mocMvc.perform(MockMvcRequestBuilders.delete("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        mocMvc.perform(MockMvcRequestBuilders.get("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deberiaActualizarUsuario() throws Exception{

        Long id = 2L;
        var persona = new PersonaDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.put("/usuarios/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk());
    }
}
