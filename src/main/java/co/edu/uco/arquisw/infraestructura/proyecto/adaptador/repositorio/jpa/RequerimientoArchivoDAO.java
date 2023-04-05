package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.RequerimientoArchivoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequerimientoArchivoDAO extends JpaRepository<RequerimientoArchivoEntidad, Long> {
    RequerimientoArchivoEntidad findByNecesidad(Long necesidad);
}