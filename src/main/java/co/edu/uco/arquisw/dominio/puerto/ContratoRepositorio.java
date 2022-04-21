package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Contrato;

public interface ContratoRepositorio
{
    Contrato consultarPorCodigo(int codigo);
    void guardar(Contrato contrato);
    void actualizar(Contrato contrato, int codigo);
    void eliminar(int codigo);
}
