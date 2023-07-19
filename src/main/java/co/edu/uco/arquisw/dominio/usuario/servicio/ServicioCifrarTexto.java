package co.edu.uco.arquisw.dominio.usuario.servicio;

public interface ServicioCifrarTexto {
    String ejecutar(String clave);
    boolean existe(String clave, String claveCifrada);
}
