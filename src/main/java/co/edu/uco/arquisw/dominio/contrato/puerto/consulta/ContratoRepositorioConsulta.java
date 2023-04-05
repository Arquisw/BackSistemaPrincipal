package co.edu.uco.arquisw.dominio.contrato.puerto.consulta;

import co.edu.uco.arquisw.dominio.contrato.dto.ContratoDTO;

public interface ContratoRepositorioConsulta {
    ContratoDTO consultarPorId(Long id);
}