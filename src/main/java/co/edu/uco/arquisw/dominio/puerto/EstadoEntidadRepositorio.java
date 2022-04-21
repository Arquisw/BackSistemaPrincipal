package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.EstadoEntidad;

public interface EstadoEntidadRepositorio
{
    EstadoEntidad consultarPorCodigo(int codigo);
}
