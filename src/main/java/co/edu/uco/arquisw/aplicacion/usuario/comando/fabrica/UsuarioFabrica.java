package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFabrica {
    public Usuario construir(String correo, String clave) {
        return Usuario.crear(correo, clave);
    }
}
