package co.edu.uco.arquisw.aplicacion.postulacion.comando.fabrica;

import co.edu.uco.arquisw.dominio.postulacion.modelo.Postulacion;
import org.springframework.stereotype.Component;

@Component
public class PostulacionFabrica
{
    public Postulacion construir()
    {
        return Postulacion.crear(false);
    }
}