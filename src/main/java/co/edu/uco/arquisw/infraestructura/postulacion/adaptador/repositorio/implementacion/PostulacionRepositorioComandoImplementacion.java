package co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import co.edu.uco.arquisw.dominio.postulacion.modelo.Seleccion;
import co.edu.uco.arquisw.dominio.postulacion.puerto.comando.PostulacionRepositorioComando;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.PostulacionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.mapeador.SeleccionMapeador;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.PostulacionDAO;
import co.edu.uco.arquisw.infraestructura.postulacion.adaptador.repositorio.jpa.SeleccionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostulacionRepositorioComandoImplementacion implements PostulacionRepositorioComando
{
    @Autowired
    PostulacionMapeador postulacionMapeador;
    @Autowired
    SeleccionMapeador seleccionMapeador;
    @Autowired
    PostulacionDAO postulacionDAO;
    @Autowired
    SeleccionDAO seleccionDAO;

    @Override
    public Long guardar(Postulacion postulacion, Long proyectoID, Long usuarioID)
    {
        var entidad = this.postulacionMapeador.construirEntidad(postulacion, proyectoID, usuarioID);

        return this.postulacionDAO.save(entidad).getId();
    }

    @Override
    public Long actualizar(Postulacion postulacion, Seleccion seleccion, Long id)
    {
        var entidad = this.postulacionDAO.getById(id);

        entidad.setSeleccionado(postulacion.isSeleccionado());

        var seleccionEntidad = this.seleccionMapeador.construirEntidad(seleccion, entidad.getProyectoID(), entidad.getUsuarioID());

        this.seleccionDAO.save(seleccionEntidad);

        return this.postulacionDAO.save(entidad).getId();
    }
}