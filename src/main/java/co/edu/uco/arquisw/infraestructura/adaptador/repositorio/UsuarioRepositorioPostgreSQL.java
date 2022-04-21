package co.edu.uco.arquisw.infraestructura.adaptador.repositorio;

import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.PerfilEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.UsuarioEntidad;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.PerfilDAO;
import co.edu.uco.arquisw.infraestructura.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UsuarioRepositorioPostgreSQL implements UsuarioRepositorio
{
    private final UsuarioDAO usuarioDAO;
    private final PerfilDAO perfilDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioRepositorioPostgreSQL(UsuarioDAO usuarioDAO, PerfilDAO perfilDAO)
    {
        this.usuarioDAO = usuarioDAO;
        this.perfilDAO = perfilDAO;
    }

    @Override
    public List<Usuario> consultar()
    {
        List<UsuarioEntidad> entidades = this.usuarioDAO.findAll();
        
        return entidades.stream().map(entidad -> Usuario.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getCorreo(), entidad.getClave(), entidad.getInstitucion(), Perfil.crear(entidad.getPerfil().getCodigo(), entidad.getPerfil().getNombre()))).toList();
    }

    @Override
    public Usuario consultarPorCodigo(int codigo)
    {
        return this.usuarioDAO.findById(codigo).map(entidad -> Usuario.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getCorreo(), entidad.getClave(), entidad.getInstitucion(), Perfil.crear(entidad.getPerfil().getCodigo(), entidad.getPerfil().getNombre()))).orElse(null);
    }

    @Override
    public Usuario consultarPorCorreo(String correo)
    {
        UsuarioEntidad usuario = this.usuarioDAO.findByCorreo(correo);
        
        return Usuario.crear(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), Perfil.crear(usuario.getPerfil().getCodigo(), usuario.getPerfil().getNombre()));
    }

    @Override
    public Usuario consultarPorNumeroIdentificacion(String numeroIdentificacion)
    {
        UsuarioEntidad usuario = this.usuarioDAO.findByNumeroIdentificacion(numeroIdentificacion);
        
        return Usuario.crear(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), Perfil.crear(usuario.getPerfil().getCodigo(), usuario.getPerfil().getNombre()));
    }

    @Override
    public void guardar(Usuario usuario)
    {
        PerfilEntidad perfil = this.perfilDAO.findById(usuario.getPerfil().getCodigo()).map(entidad -> new PerfilEntidad(entidad.getCodigo(), entidad.getNombre())).orElse(null);
        
        this.usuarioDAO.save(new UsuarioEntidad(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), passwordEncoder.encode(usuario.getClave()), usuario.getInstitucion(), perfil));
    }

    @Override
    public void actualizar(Usuario usuario, int codigo)
    {
        this.usuarioDAO.save(new UsuarioEntidad(usuario.getCodigo(), usuario.getNombre(), usuario.getApellidos(), usuario.getNumeroIdentificacion(), usuario.getCorreo(), usuario.getClave(), usuario.getInstitucion(), new PerfilEntidad(usuario.getPerfil().getCodigo(), usuario.getPerfil().getNombre())));
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