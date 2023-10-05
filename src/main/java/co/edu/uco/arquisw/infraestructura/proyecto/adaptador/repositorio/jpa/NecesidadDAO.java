package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.EstadoNecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.NecesidadEntidad;
import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.ProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NecesidadDAO extends JpaRepository<NecesidadEntidad, Long> {
    NecesidadEntidad findByAsociacion(Long asociacion);

    NecesidadEntidad findByProyecto(ProyectoEntidad proyecto);

    Page<NecesidadEntidad> findByEstado_Estado_Id(Long id, Pageable pageable);
    Page<NecesidadEntidad> findByEstado_Estado_IdOrEstado_Estado_Id(Long estadoId1, Long estadoId2, Pageable pageable);
}