package co.edu.uco.arquisw.aplicacion.servicio.usuario;

import co.edu.uco.arquisw.dominio.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarUsuario
{
    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ServicioAplicacionEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario)
    {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void eliminar(int codigo)
    {
        this.servicioEliminarUsuario.eliminar(codigo);
    }
}