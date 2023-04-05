package co.edu.uco.arquisw.infraestructura.contrato.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.contrato.adaptador.entidad.ContratoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoDAO extends JpaRepository<ContratoEntidad, Long> {
    ContratoEntidad findByNecesidad(Long necesidad);
}