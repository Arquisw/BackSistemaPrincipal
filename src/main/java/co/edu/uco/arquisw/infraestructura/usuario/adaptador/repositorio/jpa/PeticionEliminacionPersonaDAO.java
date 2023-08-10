package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;


import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionEliminacionPersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionEliminacionPersonaDAO extends JpaRepository<PeticionEliminacionPersonaEntidad, Long> {
    PeticionEliminacionPersonaEntidad findByUsuario(Long usuario);
}