package co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa;

import co.edu.uco.arquisw.infraestructura.adaptador.entidad.AsociacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsociacionDAO extends JpaRepository<AsociacionEntidad, Integer>
{
    AsociacionEntidad findByNit(String nit);
}