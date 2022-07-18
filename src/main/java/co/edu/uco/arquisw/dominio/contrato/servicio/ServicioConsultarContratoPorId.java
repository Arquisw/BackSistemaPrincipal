package co.edu.uco.arquisw.dominio.contrato.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.contrato.puerto.consulta.ContratoRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioConsultarContratoPorId
{
    private final ContratoRepositorioConsulta contratoRepositorioConsulta;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioConsultarContratoPorId(ContratoRepositorioConsulta contratoRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta)
    {
        this.contratoRepositorioConsulta = contratoRepositorioConsulta;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }


    public ContratoDTO ejecutar(Long id)
    {
        validarSiExisteAsociacionConId(id);

        return this.contratoRepositorioConsulta.consultarPorId(id);
    }

    private void validarSiExisteAsociacionConId(Long asociacionID)
    {
        if(ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(asociacionID)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + asociacionID);
        }
    }
}