package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.NecesidadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NecesidadDAO extends JpaRepository<NecesidadEntidad, Long> {
    NecesidadEntidad findByAsociacion(Long asociacion);
}