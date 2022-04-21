package co.edu.uco.arquisw.dominio.servicio.entidad;

import co.edu.uco.arquisw.dominio.modelo.Entidad;
import co.edu.uco.arquisw.dominio.puerto.EntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioGuardarEntidad
{
    private static final String MENSAJE_EXISTE = "Existe una entidad con los datos ingresados";

    private final EntidadRepositorio entidadRepositorio;

    public ServicioGuardarEntidad(EntidadRepositorio entidadRepositorio)
    {
        this.entidadRepositorio = entidadRepositorio;
    }

    public void guardar(Entidad entidad)
    {
        if(this.entidadRepositorio.existe(entidad))
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.entidadRepositorio.guardar(entidad);
    }
}