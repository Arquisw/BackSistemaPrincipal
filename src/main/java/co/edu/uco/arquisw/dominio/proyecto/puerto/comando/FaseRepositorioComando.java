package co.edu.uco.arquisw.dominio.proyecto.puerto.comando;

public interface FaseRepositorioComando {
    Long guardar(Long proyectoID, String token);
}