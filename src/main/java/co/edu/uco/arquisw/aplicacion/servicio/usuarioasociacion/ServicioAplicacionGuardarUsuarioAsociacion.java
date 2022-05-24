package co.edu.uco.arquisw.aplicacion.servicio.usuarioasociacion;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioAsociacionDTO;
import co.edu.uco.arquisw.dominio.servicio.usuarioasociacion.ServicioGuardarUsuarioAsociacion;
import org.springframework.stereotype.Component;
import static co.edu.uco.arquisw.dominio.ensamblador.implementacion.UsuarioAsociacionEnsambladorImplementacion.obtenerUsuarioAsociacionEnsamblador;

@Component
public class ServicioAplicacionGuardarUsuarioAsociacion
{
    private final ServicioGuardarUsuarioAsociacion servicioGuardarUsuarioAsociacion;

    public ServicioAplicacionGuardarUsuarioAsociacion(ServicioGuardarUsuarioAsociacion servicioGuardarUsuarioAsociacion)
    {
        this.servicioGuardarUsuarioAsociacion = servicioGuardarUsuarioAsociacion;
    }

    public void guardar(UsuarioAsociacionDTO usuarioAsociacion)
    {
        this.servicioGuardarUsuarioAsociacion.guardar(obtenerUsuarioAsociacionEnsamblador().ensamblarDominioDesdeDTO(usuarioAsociacion));
    }
}