package co.edu.uco.arquisw.dominio.servicio.usuarioasociacion;

import co.edu.uco.arquisw.dominio.modelo.Perfil;
import co.edu.uco.arquisw.dominio.modelo.Usuario;
import co.edu.uco.arquisw.dominio.modelo.UsuarioAsociacion;
import co.edu.uco.arquisw.dominio.puerto.AsociacionRepositorio;
import co.edu.uco.arquisw.dominio.puerto.PerfilRepositorio;
import co.edu.uco.arquisw.dominio.puerto.UsuarioAsociacionRepositorio;
import co.edu.uco.arquisw.dominio.puerto.UsuarioRepositorio;
import co.edu.uco.arquisw.dominio.validador.ValidarObjeto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioEnsambladorImplementacion.obtenerUsuarioEnsamblador;

@Service
public class ServicioGuardarUsuarioAsociacion
{
    private static final String MENSAJE_NO_EXISTE = "No existe un usuario con los datos ingresados";
    private final UsuarioAsociacionRepositorio usuarioAsociacionRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final AsociacionRepositorio asociacionRepositorio;
    private final PerfilRepositorio perfilRespositorio;

    public ServicioGuardarUsuarioAsociacion(UsuarioAsociacionRepositorio usuarioAsociacionRepositorio, UsuarioRepositorio usuarioRepositorio, AsociacionRepositorio asociacionRepositorio, PerfilRepositorio perfilRespositorio)
    {
        this.usuarioAsociacionRepositorio = usuarioAsociacionRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.asociacionRepositorio = asociacionRepositorio;
        this.perfilRespositorio = perfilRespositorio;
    }

    public void guardar(UsuarioAsociacion usuarioAsociacion)
    {
        verificarSiUsuarioExiste(usuarioAsociacion.getUsuario());
        verficarEntidadExistaConNIT(usuarioAsociacion.getEntidad().getNit());

        List<Perfil> perfiles = new ArrayList<>();

        perfiles.add(Perfil.crear(1, "ROLE_USER"));
        perfiles.add(Perfil.crear(2, "ROLE_USER_ENTITY"));

        this.perfilRespositorio.guardar(perfiles.get(1));
        this.usuarioRepositorio.actualizar(obtenerUsuarioEnsamblador().ensamblarDominioDesdeDominioParaModificar(usuarioAsociacion.getUsuario(), perfiles), usuarioAsociacion.getUsuario().getCodigo());
        this.usuarioAsociacionRepositorio.guardar(usuarioAsociacion);
    }

    private void verificarSiUsuarioExiste(Usuario usuario)
    {
        var usuarioResumen = this.usuarioRepositorio.consultarPorCodigo(usuario.getCodigo());

        if(ValidarObjeto.esNulo(usuarioResumen))
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }
    }

    private void verficarEntidadExistaConNIT(String nit)
    {
        var entidad = this.asociacionRepositorio.consultarPorNIT(nit);

        if(!ValidarObjeto.esNulo(entidad))
        {
            throw new IllegalArgumentException("Ya existe una entidad con el NIT" + nit);
        }
    }
}