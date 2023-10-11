package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.AsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.PeticionEliminacionAsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.AsociacionDAO;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.PeticionEliminacionAsociacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AsociacionRepositorioComandoImplementacion implements AsociacionRepositorioComando {
    @Autowired
    AsociacionMapeador asociacionMapeador;
    @Autowired
    AsociacionDAO asociacionDAO;
    @Autowired
    PeticionEliminacionAsociacionDAO peticionEliminacionAsociacionDAO;
    @Autowired
    PeticionEliminacionAsociacionMapeador peticionEliminacionAsociacionMapeador;

    @Override
    public Long guardar(Asociacion asociacion, Long usuarioID) {
        var entidad = this.asociacionMapeador.construirEntidad(asociacion, usuarioID);

        return this.asociacionDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Asociacion asociacion, Long id) {
        var entidad = this.asociacionDAO.findByUsuario(id);

        entidad.setNombre(asociacion.getNombre());
        entidad.setNit(asociacion.getNit());
        entidad.setNumeroContacto(asociacion.getNumeroContacto());

        return this.asociacionDAO.save(entidad).getId();
    }

    @Override
    public void eliminar(Long id) {
        this.asociacionDAO.deleteById(id);
    }

    @Override
    public void eliminarPorAdministrador(Long id) {
        var entidad = this.peticionEliminacionAsociacionDAO.findByAsociacion(id);

        this.peticionEliminacionAsociacionDAO.deleteById(entidad.getId());

        this.asociacionDAO.deleteById(id);
    }
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void crearNotificacionEliminacion(Long id) {
        this.peticionEliminacionAsociacionDAO.save(this.peticionEliminacionAsociacionMapeador.construirEntidad(id));
    }
}