package co.edu.uco.arquisw.infraestructura.proyecto.controlador;

import co.edu.uco.arquisw.ApplicationMock;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
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
 class NecesidadConsultaControladorTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void obtenerNecesidadExitosa() throws Exception {

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGet("/necesidades")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].rutaArchivo", is("http://www.direccion.org/ejemplo/item.html")));
    }

    @Test
    void obtenerProyectoAprobadosExitosa() throws Exception {

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGet("/necesidades/proyectos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void obtenerNecesidadPorIdExitosa() throws Exception
    {
        var  id = 3;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/necesidades/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rutaArchivo", is("http://www.direccion.org/ejemplo/item.html")));
    }
    @Test
    void obtenerProyectoPorIdExitosa() throws Exception
    {
        var  id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/necesidades/proyectos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Facebook")))
                .andExpect(jsonPath("$.descripcion", is("Red Social")));
    }
    @Test
    void obtenerNecesidarPorIdFalla() throws Exception
    {
        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/necesidades/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_NECESIDAD_CON_EL_ID + id)));
    }
    @Test
    void obtenerProyectoPorIdFalla() throws Exception
    {
        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/necesidades/proyectos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is("No existe un proyecto con el ID " + id)));;
    }
    @Test
    void obtenerPeticionesPorAdministradorExitosa() throws Exception
    {
        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGet("/necesidades/administrador")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
