package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Perfil;

public interface PerfilRepositorio
{
    Perfil consultarPorCodigo(int codigo);
    boolean existe(Perfil perfil);
}
