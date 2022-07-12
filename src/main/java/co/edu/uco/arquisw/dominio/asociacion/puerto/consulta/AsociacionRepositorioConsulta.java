package co.edu.uco.arquisw.dominio.asociacion.puerto.consulta;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;

public interface AsociacionRepositorioConsulta
{
    AsociacionDTO consultarPorID(Long id);
    AsociacionDTO consultarPorNIT(String nit);
}