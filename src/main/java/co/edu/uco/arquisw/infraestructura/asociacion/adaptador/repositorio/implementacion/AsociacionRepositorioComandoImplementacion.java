package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.AsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.AsociacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AsociacionRepositorioComandoImplementacion implements AsociacionRepositorioComando
{
    @Autowired
    AsociacionMapeador asociacionMapeador;
    @Autowired
    AsociacionDAO asociacionDAO;

    @Override
    public Long guardar(Asociacion asociacion, Long usuarioID)
    {
        var entidad = this.asociacionMapeador.construirEntidad(asociacion, usuarioID);

        entidad.setId(obtenerAsociacionID());

        return this.asociacionDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Asociacion asociacion, Long id)
    {
        var entidad = this.asociacionDAO.findByUsuario(id);

        entidad.setNombre(asociacion.getNombre());
        entidad.setNit(asociacion.getNit());
        entidad.setNumeroContacto(asociacion.getNumeroContacto());

        return this.asociacionDAO.save(entidad).getId();
    }

    private Long obtenerAsociacionID()
    {
        var id = 1L;
        var asociaciones = this.asociacionDAO.findAll();

        if(!asociaciones.isEmpty())
        {
            id = asociaciones.get(asociaciones.size() - 1).getId() + 1L;
        }

        return id;
    }
}