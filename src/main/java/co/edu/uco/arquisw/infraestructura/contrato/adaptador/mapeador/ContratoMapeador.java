package co.edu.uco.arquisw.infraestructura.contrato.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;
import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;
import co.edu.uco.arquisw.infraestructura.contrato.adaptador.entidad.ContratoEntidad;
import org.springframework.stereotype.Component;

@Component
public class ContratoMapeador
{
    public ContratoDTO construirDTO(ContratoEntidad contrato)
    {
        return new ContratoDTO(contrato.getId(), contrato.getRuta(), contrato.getAsociacion());
    }

    public ContratoEntidad construirEntidad(Contrato contrato, Long asociacionId)
    {
        return new ContratoEntidad(0L, contrato.getRutaArchivo(), asociacionId);
    }
}
