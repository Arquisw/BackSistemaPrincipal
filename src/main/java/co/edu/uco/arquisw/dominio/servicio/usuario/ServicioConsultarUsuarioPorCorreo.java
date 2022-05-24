package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.dto.UsuarioResumenDTO;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuarioPorCorreo
{
    private static final String MENSAJE_NO_EXISTE = "El usuario al que pertenece ese correo, no existe.";

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioConsultarUsuarioPorCorreo(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public UsuarioResumenDTO consultarPorCorreo(String correo)
    {
        if(ValidarObjeto.esNulo(this.usuarioRepositorio.consultarPorCorreo(correo)))
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }

        return this.usuarioRepositorio.consultarPorCorreo(correo);
    }
}
