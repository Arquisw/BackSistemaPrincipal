package co.edu.uco.arquisw.dominio.servicio.entidad;

import co.edu.uco.arquisw.dominio.modelo.Entidad;
import co.edu.uco.arquisw.dominio.puerto.EntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioActualizarEntidad
{
    private static final String MENSAJE_EXISTE = "No existe una entidad con el codigo ingresado";

    private final EntidadRepositorio entidadRepositorio;

    public ServicioActualizarEntidad(EntidadRepositorio entidadRepositorio)
    {
        this.entidadRepositorio = entidadRepositorio;
    }

    public void actualizar(int codigo, Entidad entidad)
    {
        if(this.entidadRepositorio.consultarPorCodigo(codigo) == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.entidadRepositorio.actualizar(entidad,codigo);
    }
}
