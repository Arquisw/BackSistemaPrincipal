package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioConsultarUsuarios
{
    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioConsultarUsuarios(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> consultar()
    {
        return this.usuarioRepositorio.consultar();
    }
}
