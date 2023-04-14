package co.edu.uco.arquisw.infraestructura.postulacion.controlador;

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
class PostulacionConsultaControladorTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void obtenerPostulacionPorIdExitosa() throws Exception {

        var id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/postulacion/{id}",id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fecha", is("13/07/2022")));
    }
    @Test
    void obtenerPostulacionPorIdFalla() throws Exception {

        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/postulacion/{id}",id,"ROLE_ADMINISTRADOR")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id)));;
    }
    @Test
    void obtenerPostulacionPorIdUsuarioExitosa() throws Exception {

        var id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/postulacion/usuario/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fecha", is("12/07/2022")));
    }
    @Test
    void obtenerPostulacionPorIdUsuarioFalla() throws Exception {

        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/postulacion/usuario/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));;
    }
    @Test
    void obtenerPostulacionPorSelecionExitosa() throws Exception {

        var id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/selecciones/seleccion/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fecha", is("14/07/2022")));
    }
    @Test
    void obtenerPostulacionPorSeleccionFalla() throws Exception {

        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/selecciones/seleccion/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_POSTULACION_CON_EL_ID + id)));;
    }
    @Test
    void obtenerSelccionPorUsuarioExitosa() throws Exception {

        var id = 3;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/selecciones/seleccion/usuario/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fecha", is("14/07/2022")));
    }
    @Test
    void obtenerSelccionPorUsuarioFalla() throws Exception {

        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/selecciones/seleccion/usuario/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id)));;
    }
    @Test
    void obtenerSeleccionPorIdExitosa() throws Exception {

        var id = 2;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/selecciones/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void obtenerSeleccionPorIdFalla() throws Exception {

        var id = 9;

        mocMvc.perform(MyTestRequestFactory.myFactoryRequestAuthenticatedGetOne("/postulaciones/selecciones/{id}",id,"ROLE_USUARIO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("NullPointerException")))
                .andExpect(jsonPath("$.mensaje", is(Mensajes.NO_EXISTE_PROYECTO_CON_EL_ID + id)));;
    }

}
