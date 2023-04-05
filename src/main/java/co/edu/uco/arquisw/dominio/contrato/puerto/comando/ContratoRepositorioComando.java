package co.edu.uco.arquisw.dominio.contrato.puerto.comando;

import co.edu.uco.arquisw.dominio.contrato.modelo.Contrato;

public interface ContratoRepositorioComando {
    Long guardar(Contrato contrato, Long id);
    Long actualizar(Contrato contrato, Long id);
    void eliminar(Long id);
}