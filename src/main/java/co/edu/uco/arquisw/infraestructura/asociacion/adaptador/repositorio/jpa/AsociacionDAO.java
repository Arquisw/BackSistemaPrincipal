package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.entidad.AsociacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsociacionDAO extends JpaRepository<AsociacionEntidad, Long>
{
    AsociacionEntidad findByUsuario(Long usuario);
    AsociacionEntidad findByNit(String nit);
}