package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Perfil;

public interface PerfilRepositorio
{
    Perfil consultarPorCodigo(int codigo);
    void guardar(Perfil perfil);
    void actualizar(int codigo, Perfil perfil);
    void eliminar(int codigo);
    boolean existe(Perfil perfil);
}
