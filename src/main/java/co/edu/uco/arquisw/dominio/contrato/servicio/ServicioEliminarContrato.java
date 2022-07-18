package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.puerto.comando.ContratoRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioEliminarContrato
{
    private final ContratoRepositorioComando contratoRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioEliminarContrato(ContratoRepositorioComando contratoRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        this.contratoRepositorioComando = contratoRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public Long ejecutar(Long id)
    {
        validarSiExisteAsociacionConId(id);

        this.contratoRepositorioComando.eliminar(id);

        return id;
    }

    private void validarSiExisteAsociacionConId(Long asociacionID)
    {
        if(ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(asociacionID)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + asociacionID);
        }
    }
}