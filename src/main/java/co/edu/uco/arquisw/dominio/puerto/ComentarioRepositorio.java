package co.edu.uco.arquisw.dominio.puerto;

import co.edu.uco.arquisw.dominio.modelo.Comentario;
import java.util.List;

public interface ComentarioRepositorio
{
    List<Comentario> consultar();
    void guardar(Comentario comentario);
    void actualizar(Comentario comentario, int codigo);
    void eliminar(int codigo);
}
