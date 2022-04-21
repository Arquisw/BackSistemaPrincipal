package co.edu.uco.arquisw.dominio.servicio.entidad;

import co.edu.uco.arquisw.dominio.modelo.Entidad;
import co.edu.uco.arquisw.dominio.puerto.EntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioConsultarEntidadPorCodigo
{
    private static final String MENSAJE_EXISTE = "No existe una entidad con el codigo ingresado";

    private final EntidadRepositorio entidadRepositorio;

    public ServicioConsultarEntidadPorCodigo(EntidadRepositorio entidadRepositorio)
    {
        this.entidadRepositorio = entidadRepositorio;
    }

    public Entidad consultarPorCodigo(int codigo)
    {
        var entidad = this.entidadRepositorio.consultarPorCodigo(codigo);

        if(entidad == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        return entidad;
    }
}
