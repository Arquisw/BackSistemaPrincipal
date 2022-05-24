package co.edu.uco.arquisw.dominio.servicio.usuario;

import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarUsuario
{
    private static final String MENSAJE_NO_EXISTE = "El usuario al que pertenece ese codigo, no existe.";
    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioEliminarUsuario(UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void eliminar(int codigo)
    {
        if(ValidarObjeto.esNulo(this.usuarioRepositorio.consultarPorCodigo(codigo)))
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }

        this.usuarioRepositorio.eliminar(codigo);
    }
}