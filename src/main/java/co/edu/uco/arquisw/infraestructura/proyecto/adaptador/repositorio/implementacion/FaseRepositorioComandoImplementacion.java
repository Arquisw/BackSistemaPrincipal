package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.FaseRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.excepciones.DemasiadasPeticionesExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.TecnicoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Repository
public class FaseRepositorioComandoImplementacion implements FaseRepositorioComando {
    private static final Logger logger = LoggerFactory.getLogger(FaseRepositorioComandoImplementacion.class);
    private final RestTemplate restTemplate;

    public FaseRepositorioComandoImplementacion(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Long guardar(Long proyectoID, String token) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(TextoConstante.HEADER_VALUE, token);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            String url = TextoConstante.INGENIERIA_DE_REQUISITOS_URL + proyectoID;
            ComandoRespuesta<Long> response = this.restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<ComandoRespuesta<Long>>() {
                    }).getBody();

            assert response != null;
            return response.getValor();
        } catch (HttpStatusCodeException exception) {
            logger.error("Error consumiendo el servicio de Ingeniería de Requisitos", exception);

            if (exception.getStatusCode().is4xxClientError()) {
                throw new DemasiadasPeticionesExcepcion(exception.getMessage());
            } else {
                throw new TecnicoExcepcion(exception.getMessage());
            }
        }
    }
}