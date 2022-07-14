package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.HojaDeVidaPersonaEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.PeticionEliminacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionEliminacionDAO extends JpaRepository<PeticionEliminacionEntidad, Long>
{
    HojaDeVidaPersonaEntidad findByUsuario(Long usuario);
}
