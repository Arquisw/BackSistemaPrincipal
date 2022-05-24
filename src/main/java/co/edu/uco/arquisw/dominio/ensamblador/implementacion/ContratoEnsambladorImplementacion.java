package co.edu.uco.arquisw.dominio.ensamblador.implementacion;

import co.edu.uco.arquisw.aplicacion.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.ensamblador.ContratoEnsamblador;
import co.edu.uco.arquisw.dominio.modelo.Contrato;
import co.edu.uco.arquisw.infraestructura.adaptador.entidad.ContratoEntidad;

public class ContratoEnsambladorImplementacion implements ContratoEnsamblador
{
    private static final ContratoEnsamblador INSTANCE = new ContratoEnsambladorImplementacion();

    private ContratoEnsambladorImplementacion()
    {

    }

    public static ContratoEnsamblador obtenerContratoEnsamblador()
    {
        return INSTANCE;
    }

    @Override
    public Contrato ensamblarDominioDesdeEntidad(ContratoEntidad entidad)
    {
        return null;
    }

    @Override
    public ContratoEntidad ensamblarEntidadDesdeDominio(Contrato dominio)
    {
        return null;
    }

    @Override
    public Contrato ensamblarDominioDesdeDTO(ContratoDTO dto)
    {
        return null;
    }

    @Override
    public ContratoDTO ensamblarDTODesdeDominio(Contrato dominio)
    {
        return null;
    }
}
