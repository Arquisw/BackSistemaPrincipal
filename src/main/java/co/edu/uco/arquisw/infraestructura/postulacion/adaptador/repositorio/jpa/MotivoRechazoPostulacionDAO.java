package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.entidad.MotivoRechazoPostulacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoRechazoPostulacionDAO extends JpaRepository<MotivoRechazoPostulacionEntidad, Long> {
    MotivoRechazoPostulacionEntidad findByPostulacion(Long postulacion);
}
