package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.modelo.EstadoAsociacion;
import co.edu.uco.arquisw.dominio.puerto.EstadoAsociacionRepositorio;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.EstadoDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.EstadoAsociacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.EstadoAsociacionEnsambladorImplementacion.obtenerEstadoAsociacionEnsamblador;

@Repository
public class EstadoAsociacionRepositorioPostgreSQL implements EstadoAsociacionRepositorio
{
    @Autowired
    private EstadoAsociacionDAO estadoAsociacionDAO;
    @Autowired
    private EstadoDAO estadoDAO;

    @Override
    public EstadoAsociacion consultarPorCodigo(int codigo)
    {
        return this.estadoAsociacionDAO.findById(codigo).map(obtenerEstadoAsociacionEnsamblador()::ensamblarDominioDesdeEntidad).orElse(null);
    }

    @Override
    public void guardar(EstadoAsociacion estadoAsociacion)
    {
        var estado = this.estadoDAO.findById(estadoAsociacion.getCodigo()).orElse(null);
        var estadosEntidad = this.estadoAsociacionDAO.findAll();
        var ultimoIndice = 1;

        if(!estadosEntidad.isEmpty())
        {
            ultimoIndice = estadosEntidad.get(estadosEntidad.size() - 1).getCodigo() + 1;
        }

        this.estadoAsociacionDAO.save(obtenerEstadoAsociacionEnsamblador().ensamblarEntidadDesdeDominioParaGuardar(ultimoIndice, estado));
    }

    @Override
    public void actualizar(EstadoAsociacion estadoAsociacion, int codigo)
    {
        var estadoEntidadEntidad = obtenerEstadoAsociacionEnsamblador().ensamblarEntidadDesdeDominio(estadoAsociacion);

        estadoEntidadEntidad.setCodigo(codigo);

        this.estadoAsociacionDAO.save(estadoEntidadEntidad);
    }

    @Override
    public void eliminar(int codigo)
    {
        this.estadoAsociacionDAO.deleteById(codigo);
    }

    @Override
    public boolean existe(EstadoAsociacion estadoAsociacion)
    {
        return this.estadoAsociacionDAO.existsById(estadoAsociacion.getCodigo());
    }
}