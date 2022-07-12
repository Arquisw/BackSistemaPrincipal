package co.edu.uco.arquisw.dominio.asociacion.servicio;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import java.util.Objects;

public class ServicioActualizarAsociacion
{
    private final AsociacionRepositorioComando asociacionRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioActualizarAsociacion(AsociacionRepositorioComando asociacionRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        this.asociacionRepositorioComando = asociacionRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public Long ejecutar(Asociacion asociacion, Long id)
    {
        validarSiExisteAsociacionConID(id);
        validarSiExisteAsociacionConNIT(asociacion.getNit(), id);

        return this.asociacionRepositorioComando.actualizar(asociacion, id);
    }

    private void validarSiExisteAsociacionConID(Long id)
    {
        if(ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(id)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + id);
        }
    }

    private void validarSiExisteAsociacionConNIT(String nit, Long id)
    {
        var asociacionConNIT = this.asociacionRepositorioConsulta.consultarPorNIT(nit);

        if(!ValidarObjeto.esNulo(asociacionConNIT) && !Objects.equals(asociacionConNIT.getId(), id))
        {
            throw new DuplicidadExcepcion(Mensajes.EXISTE_ASOCIACION_CON_NIT + nit);
        }
    }
}