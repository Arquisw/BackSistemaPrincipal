package co.edu.uco.arquisw.infraestructura.postulacion.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.infraestructura.postulacion.testdatabuilder.PostulacionDtoTestDataBuilder;
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
 class PostulacionComandoControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void guardarPostulacion() throws Exception {

        var postulacion = new PostulacionDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.post("/postulaciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postulacion)))
                .andExpect(status().isOk());

    }
    @Test
    void guardarPostulacionFallida() throws Exception {

        var postulacion = new PostulacionComando(1L,1L);

        mocMvc.perform(MockMvcRequestBuilders.post("/postulaciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postulacion)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + postulacion.getUsuarioID())));
    }
    @Test
    void deberiaActualizarPostulacion() throws Exception {

        Long id = 3L;
        var postulacion = new PostulacionDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.put("/postulaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postulacion)))
                        .andExpect(status().isOk());
    }
    @Test
    void deberiaFallarAlActualizarPersona() throws Exception {

        Long id = 9L;
        var postulacion = new PostulacionDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.put("/postulaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postulacion)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id)));
    }
}
