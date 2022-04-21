package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.puerto.PerfilRepositorio;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.PerfilDAO;
import org.springframework.stereotype.Repository;

@Repository
public class PerfilRespositorioPostgreSQL implements PerfilRepositorio
{
    private final PerfilDAO perfilDAO;

    public PerfilRespositorioPostgreSQL(PerfilDAO perfilDAO)
    {
        this.perfilDAO = perfilDAO;
    }

    @Override
    public Perfil consultarPorCodigo(int codigo)
    {
        return this.perfilDAO.findById(codigo).map(entidad -> Perfil.crear(entidad.getCodigo(), entidad.getNombre())).orElse(null);
    }

    @Override
    public boolean existe(Perfil perfil)
    {
        return perfilDAO.existsById(perfil.getCodigo());
    }
}