package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.puerto.PerfilRepositorio;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.PerfilDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.PerfilUsuarioDAO;
import org.springframework.stereotype.Repository;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.PerfilEnsambladorImplementacion.obtenerPerfilEnsamblador;

@Repository
public class PerfilUsuarioRespositorioPostgreSQL implements PerfilRepositorio
{
    private final PerfilUsuarioDAO perfilUsuarioDAO;
    private final PerfilDAO perfilDAO;

    public PerfilUsuarioRespositorioPostgreSQL(PerfilUsuarioDAO perfilUsuarioDAO, PerfilDAO perfilDAO)
    {
        this.perfilUsuarioDAO = perfilUsuarioDAO;
        this.perfilDAO = perfilDAO;
    }

    @Override
    public Perfil consultarPorCodigo(int codigo)
    {
        return this.perfilUsuarioDAO.findById(codigo).map(obtenerPerfilEnsamblador()::ensamblarDominioDesdeEntidad).orElse(null);
    }

    @Override
    public void guardar(Perfil perfil)
    {
        var perfilUsuario = this.perfilDAO.findById(perfil.getCodigo()).orElse(null);
        var perfiles = this.perfilUsuarioDAO.findAll();
        var ultimoIndice = 1;

        if(!perfiles.isEmpty())
        {
            ultimoIndice = perfiles.get(perfiles.size() - 1).getCodigo() + 1;
        }

        this.perfilUsuarioDAO.save(obtenerPerfilEnsamblador().ensamblarEntidadDesdeDominioParaGuardar(ultimoIndice, perfilUsuario));
    }

    @Override
    public void actualizar(int codigo, Perfil perfil)
    {
        var perfilEntidad = obtenerPerfilEnsamblador().ensamblarEntidadDesdeDominio(perfil);

        perfilEntidad.setCodigo(codigo);

        this.perfilUsuarioDAO.save(perfilEntidad);
    }

    @Override
    public void eliminar(int codigo)
    {
        this.perfilUsuarioDAO.deleteById(codigo);
    }

    @Override
    public boolean existe(Perfil perfil)
    {
        return perfilUsuarioDAO.existsById(perfil.getCodigo());
    }
}