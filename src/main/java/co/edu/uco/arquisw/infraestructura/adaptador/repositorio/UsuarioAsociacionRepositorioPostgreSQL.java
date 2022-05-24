package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import co.edu.uco.arquisw.dominio.puerto.UsuarioAsociacionRepositorio;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.UsuarioAsociacionDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioAsociacionEnsambladorImplementacion.obtenerUsuarioAsociacionEnsamblador;

@Repository
public class UsuarioAsociacionRepositorioPostgreSQL implements UsuarioAsociacionRepositorio
{
    @Autowired
    private UsuarioAsociacionDAO usuarioAsociacionDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public List<UsuarioAsociacion> consultar()
    {
        return this.usuarioAsociacionDAO.findAll().stream().map(obtenerUsuarioAsociacionEnsamblador()::ensamblarDominioDesdeEntidad).toList();
    }

    @Override
    public UsuarioAsociacion consultarPorCodigo(int codigo)
    {
        return this.usuarioAsociacionDAO.findById(codigo).map(obtenerUsuarioAsociacionEnsamblador()::ensamblarDominioDesdeEntidad).orElse(null);
    }

    @Override
    public void guardar(UsuarioAsociacion usuarioAsociacion)
    {
        var usuario = this.usuarioDAO.findById(usuarioAsociacion.getUsuario().getCodigo()).orElse(null);
        var usuarioAsociacionEntidad = obtenerUsuarioAsociacionEnsamblador().ensamblarEntidadDesdeDominio(usuarioAsociacion);

        usuarioAsociacionEntidad.setUsuario(usuario);

        this.usuarioAsociacionDAO.save(usuarioAsociacionEntidad);
    }

    @Override
    public void actualizar(UsuarioAsociacion usuarioAsociacion, int codigo)
    {
        var usuarioAsociacionEntidad = obtenerUsuarioAsociacionEnsamblador().ensamblarEntidadDesdeDominio(usuarioAsociacion);

        usuarioAsociacionEntidad.setCodigo(codigo);

        this.usuarioAsociacionDAO.save(usuarioAsociacionEntidad);
    }

    @Override
    public void eliminar(int codigo)
    {
        this.usuarioAsociacionDAO.deleteById(codigo);
    }

    @Override
    public boolean existe(UsuarioAsociacion usuarioAsociacion)
    {
        return this.usuarioAsociacionDAO.existsById(usuarioAsociacion.getCodigo());
    }
}