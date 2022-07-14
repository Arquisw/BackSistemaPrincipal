package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.HojaDeVidaPersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HojaDeVidaPersonaDAO extends JpaRepository<HojaDeVidaPersonaEntidad, Long>
{
    HojaDeVidaPersonaEntidad findByUsuario(Long usuario);
}