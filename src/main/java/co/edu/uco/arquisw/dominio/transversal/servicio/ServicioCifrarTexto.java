package co.edu.uco.arquisw.dominio.transversal.servicio;

public interface ServicioCifrarTexto {
    String ejecutar(String clave);
    boolean existe(String clave, String claveCifrada);
}
