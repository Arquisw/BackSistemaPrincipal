package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad.PeticionEliminacionAsociacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionEliminacionAsociacionDAO extends JpaRepository<PeticionEliminacionAsociacionEntidad, Long> {
    PeticionEliminacionAsociacionEntidad findByAsociacion(Long asociacion);
}