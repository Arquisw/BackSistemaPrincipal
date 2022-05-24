package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.puerto.AsociacionRepositorio;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.AsociacionDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.EstadoAsociacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.AsociacionEnsambladorImplementacion.obtenerAsociacionEnsamblador;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.EstadoAsociacionEnsambladorImplementacion.obtenerEstadoAsociacionEnsamblador;

@Repository
public class AsociacionRespositorioPostgreSQL implements AsociacionRepositorio
{
    @Autowired
    private AsociacionDAO asociacionDAO;
    @Autowired
    private EstadoAsociacionDAO estadoAsociacionDAO;

    @Override
    public List<Asociacion> consultar()
    {
        return this.asociacionDAO.findAll().stream().map(obtenerAsociacionEnsamblador()::ensamblarDominioDesdeEntidad).toList();
    }

    @Override
    public Asociacion consultarPorCodigo(int codigo)
    {
        return this.asociacionDAO.findById(codigo).map(obtenerAsociacionEnsamblador()::ensamblarDominioDesdeEntidad).orElse(null);
    }

    @Override
    public Asociacion consultarPorNIT(String nit)
    {
        var entidad = this.asociacionDAO.findByNit(nit);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return obtenerAsociacionEnsamblador().ensamblarDominioDesdeEntidad(entidad);
    }

    @Override
    public void guardar(Asociacion asociacion)
    {
        var estado = estadoAsociacionDAO.findById(asociacion.getEstado().getCodigo()).map(obtenerEstadoAsociacionEnsamblador()::ensamblarDominioDesdeEntidad).orElse(null);

        var entidadEntidad = obtenerAsociacionEnsamblador().ensamblarEntidadDesdeDominioParaGuardar(asociacion, obtenerEstadoAsociacionEnsamblador().ensamblarEntidadDesdeDominio(estado));

        this.asociacionDAO.save(entidadEntidad);
    }

    @Override
    public void actualizar(Asociacion asociacion, int codigo)
    {
        var entidadEntidad = obtenerAsociacionEnsamblador().ensamblarEntidadDesdeDominio(asociacion);

        entidadEntidad.setCodigo(codigo);

        this.asociacionDAO.save(entidadEntidad);
    }

    @Override
    public void eliminar(int codigo)
    {
        this.asociacionDAO.deleteById(codigo);
    }

    @Override
    public boolean existe(Asociacion asociacion)
    {
        return this.asociacionDAO.existsById(asociacion.getCodigo());
    }
}