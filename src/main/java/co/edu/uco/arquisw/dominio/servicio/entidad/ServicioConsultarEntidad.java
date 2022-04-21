package co.edu.uco.arquisw.dominio.servicio.entidad;

import co.edu.uco.arquisw.dominio.modelo.Entidad;
import co.edu.uco.arquisw.dominio.puerto.EntidadRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

public class ServicioConsultarEntidad
{
    private final EntidadRepositorio entidadRepositorio;

    public ServicioConsultarEntidad(EntidadRepositorio entidadRepositorio)
    {
        this.entidadRepositorio = entidadRepositorio;
    }

    public List<Entidad> consultar()
    {
        return this.entidadRepositorio.consultar();
    }
}
