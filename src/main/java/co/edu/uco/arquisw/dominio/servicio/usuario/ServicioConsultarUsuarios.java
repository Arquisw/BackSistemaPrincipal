package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
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

    public List<UsuarioResumenDTO> consultar()
    {
        if(this.usuarioRepositorio.consultar().isEmpty())
        {
            throw new IllegalArgumentException("No hay usuarios registrados en la plataforma");
        }
        return this.usuarioRepositorio.consultar();
    }
}
