package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.UsuarioEntidad;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapeador {
    public UsuarioEntidad construirEntidad(String correo, String clave) {
        return new UsuarioEntidad(0L, correo, clave);
    }

    public void actualizarEntidad(UsuarioEntidad usuario, String correo, String clave) {
        usuario.setCorreo(correo);
        usuario.setClave(clave);
    }
}