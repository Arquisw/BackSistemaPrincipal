package co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador;

import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.UsuarioEntidad;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapeador {
    private final RolMapeador rolMapeador;

    public UsuarioMapeador(RolMapeador rolMapeador) {
        this.rolMapeador = rolMapeador;
    }

    public UsuarioDTO construirDTO(UsuarioEntidad usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getCorreo(), usuario.isActivado(), this.rolMapeador.construirDTOs(usuario.getRoles()));
    }

    public UsuarioEntidad construirEntidad(Usuario usuario, String clave) {
        return new UsuarioEntidad(0L, usuario.getCorreo(), clave, usuario.isActivado(), this.rolMapeador.construirEntidades(usuario.getRoles()));
    }

    public void actualizarEntidad(UsuarioEntidad usuario, String correo, String clave) {
        usuario.setCorreo(correo);
        usuario.setClave(clave);
    }
}