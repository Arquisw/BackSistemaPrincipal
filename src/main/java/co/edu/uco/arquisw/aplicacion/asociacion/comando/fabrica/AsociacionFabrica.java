package co.edu.uco.arquisw.aplicacion.asociacion.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.asociacion.comando.AsociacionComando;
import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import org.springframework.stereotype.Component;

@Component
public class AsociacionFabrica
{
    public Asociacion construir(AsociacionComando asociacion)
    {
        return Asociacion.crear(asociacion.getNombre(), asociacion.getNit(), asociacion.getNumeroContacto());
    }
}
