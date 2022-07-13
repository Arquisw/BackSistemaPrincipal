package co.edu.uco.arquisw.infraestructura.proyecto.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.proyecto.adaptador.entidad.HojaDeVidaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HojaDeVidaDAO extends JpaRepository<HojaDeVidaEntidad, Long>
{
    HojaDeVidaEntidad findByNecesidad(Long necesidad);
}
