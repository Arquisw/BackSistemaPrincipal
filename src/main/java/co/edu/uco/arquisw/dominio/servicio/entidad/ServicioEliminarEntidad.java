package co.edu.uco.arquisw.dominio.servicio.entidad;

import co.edu.uco.arquisw.dominio.puerto.EntidadRepositorio;
import org.springframework.stereotype.Service;

public class ServicioEliminarEntidad
{
    private static final String MENSAJE_EXISTE = "No existe una entidad con el codigo ingresado";

    private final EntidadRepositorio entidadRepositorio;

    public ServicioEliminarEntidad(EntidadRepositorio entidadRepositorio)
    {
        this.entidadRepositorio = entidadRepositorio;
    }

    public void eliminar(int codigo)
    {
        if(this.entidadRepositorio.consultarPorCodigo(codigo) == null)
        {
            throw new IllegalArgumentException(MENSAJE_EXISTE);
        }

        this.entidadRepositorio.eliminar(codigo);
    }
}