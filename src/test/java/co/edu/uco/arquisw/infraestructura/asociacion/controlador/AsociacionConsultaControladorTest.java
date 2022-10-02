package co.edu.uco.arquisw.infraestructura.asociacion.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.infraestructura.MyTestRequestFactory;
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
class AsociacionConsultaControladorTest
{
    @Autowired
    private MockMvc mocMvc;

    @Test
    void obtenerAsociacionPorIdExitosa() throws Exception
    {
        var  id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/asociaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Uco")))
                .andExpect(jsonPath("$.nit", is("12345678-2")));
    }

   @Test
    void obtenerAsociacionPorIdFalla() throws Exception
    {
        var id = 10;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/asociaciones/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is("No existe un asociacion con el ID " + id)));;
    }
    @Test
    void obtenerPeticionesPorAdministradorExitosa() throws Exception
    {
        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGet("/asociaciones/administrador")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
