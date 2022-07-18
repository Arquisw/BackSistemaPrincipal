package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.aplicacion.postulacion.comando.PostulacionComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.infraestructura.postulacion.testdatabuilder.PostulacionDtoTestDataBuilder;
import co.edu.uco.arquisw.infraestructura.proyecto.testdatabuilder.NecesidadDtoTestDataBuilder;
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
class NecesidadComandoControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    @Test
    void guardarNecesidad() throws Exception {

        var necesidad = new NecesidadDtoTestDataBuilder().build();
        var id = 2;


        mocMvc.perform(MockMvcRequestBuilders.post("/necesidades/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(necesidad)))
                .andExpect(status().isOk());

        mocMvc.perform(MockMvcRequestBuilders.get("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void guardarNecesidadFallida() throws Exception {

        var necesidad = new NecesidadDtoTestDataBuilder().build();
        var id = 1;

        mocMvc.perform(MockMvcRequestBuilders.post("/necesidades/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(necesidad)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id)));
    }

    @Test
    void deberiaActualizarNecesidad() throws Exception {

        var id = 3;
        var necesidad = new NecesidadDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.put("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(necesidad)))
                .andExpect(status().isOk());
    }
    @Test
    void deberiaFallarAlActualizar() throws Exception {

        Long id = 9L;
        var necesidad = new NecesidadDtoTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.put("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(necesidad)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + id)));
    }
    @Test
    void eliminacionNecesidadExitosa() throws Exception {

        var id = 3;

        mocMvc.perform(MockMvcRequestBuilders.delete("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void eliminacionNecesidadFallida() throws Exception {
        var id = 9;

        mocMvc.perform(MockMvcRequestBuilders.delete("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id)));
    }
    @Test
    void eliminacionNecesidadFallidaPorEstadoAprobado() throws Exception {

        var id = 4;

        mocMvc.perform(MockMvcRequestBuilders.delete("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("AutorizacionExcepcion")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_NECESIDAD_APROBADA_PARA_SU_DESARROLLO )));;
    }
    @Test
    void eliminacionNecesidadAdministradorExitosa() throws Exception {
        var id = 3;

        mocMvc.perform(MockMvcRequestBuilders.delete("/necesidades/administrador/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(MockMvcRequestBuilders.get("/necesidades/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
    @Test
    void eliminacionNecesidadAdministradorFallida() throws Exception {
        var id = 9;

        mocMvc.perform(MockMvcRequestBuilders.delete("/necesidades/administrador/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id)));
    }

}
