package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilUsuarioEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.PerfilDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.PerfilUsuarioDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioEnsambladorImplementacion.obtenerUsuarioEnsamblador;

@Repository
public class UsuarioRepositorioPostgreSQL implements UsuarioRepositorio
{
    private final UsuarioDAO usuarioDAO;
    private final PerfilDAO perfilDAO;
    private final PerfilUsuarioDAO perfilUsuarioDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioRepositorioPostgreSQL(UsuarioDAO usuarioDAO, PerfilDAO perfilDAO, PerfilUsuarioDAO perfilUsuarioDAO)
    {
        this.usuarioDAO = usuarioDAO;
        this.perfilDAO = perfilDAO;
        this.perfilUsuarioDAO = perfilUsuarioDAO;
    }

    @Override
    public List<UsuarioResumenDTO> consultar()
    {
        return this.usuarioDAO.findAll().stream().map(obtenerUsuarioEnsamblador()::ensamblarResumenDTODesdeEntidad).toList();
    }

    @Override
    public UsuarioResumenDTO consultarPorCodigo(int codigo)
    {
        return this.usuarioDAO.findById(codigo).map(obtenerUsuarioEnsamblador()::ensamblarResumenDTODesdeEntidad).orElse(null);
    }

    @Override
    public UsuarioResumenDTO consultarPorCorreo(String correo)
    {
        var usuario = this.usuarioDAO.findByCorreo(correo);

        if(ValidarObjeto.esNulo(usuario))
        {
            return null;
        }

        return obtenerUsuarioEnsamblador().ensamblarResumenDTODesdeEntidad(usuario);
    }

    @Override
    public Usuario consultarPorCorreoConClave(String correo)
    {
        var usuario = this.usuarioDAO.findByCorreo(correo);

        if(ValidarObjeto.esNulo(usuario))
        {
            return null;
        }

        return obtenerUsuarioEnsamblador().ensamblarDominioDesdeEntidad(usuario);
    }

    @Override
    public UsuarioResumenDTO consultarPorNumeroIdentificacion(String numeroIdentificacion)
    {
        var usuario = this.usuarioDAO.findByNumeroIdentificacion(numeroIdentificacion);

        if(ValidarObjeto.esNulo(usuario))
        {
            return null;
        }

        return obtenerUsuarioEnsamblador().ensamblarResumenDTODesdeEntidad(usuario);
    }

    @Override
    public void guardar(Usuario usuario)
    {
        List<PerfilUsuarioEntidad> perfilesFiltrados = new ArrayList<>();
        var perfiles = this.perfilUsuarioDAO.findAll().stream().toList();
        var perfil = perfiles.get(perfiles.size() - 1);

        perfilesFiltrados.add(perfil);

        var usuarioEntidad = obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuario);

        usuarioEntidad.setPerfiles(perfilesFiltrados);
        usuarioEntidad.setClave(passwordEncoder.encode(usuario.getClave()));

        this.usuarioDAO.save(usuarioEntidad);
    }

    @Override
    public void actualizar(Usuario usuario, int codigo)
    {
        List<PerfilUsuarioEntidad> perfilesFiltrados = new ArrayList<>();
        var perfiles = this.perfilUsuarioDAO.findAll().stream().toList();
        int i = 0;

        perfiles.stream().forEach(perfil ->
        {
            if(perfil.getPerfil().getNombre().equals(usuario.getPerfiles().get(i).getNombre()))
            {
                perfilesFiltrados.add(perfil);

            }
        });

        var usuarioEntidad = obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuario);

        usuarioEntidad.setCodigo(codigo);
        usuarioEntidad.setPerfiles(perfilesFiltrados);
        usuarioEntidad.setClave(passwordEncoder.encode(usuario.getClave()));

        this.usuarioDAO.save(usuarioEntidad);
    }

    @Override
    public void eliminar(int codigo)
    {
        this.usuarioDAO.deleteById(codigo);
    }

    @Override
    public boolean existe(Usuario usuario)
    {
        return this.usuarioDAO.existsById(usuario.getCodigo());
    }
}