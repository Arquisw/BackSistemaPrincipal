package co.edu.uco.arquisw.dominio.usuario.testdatabuilder;

import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import co.edu.uco.arquisw.dominio.usuario.modelo.Usuario;
import java.util.List;

public class UsuarioTestDataBuilder {
    private final String correo;
    private final String clave;
    private final List<Rol> roles;

    public UsuarioTestDataBuilder() {
        this.correo = "jjuandiego23@gmail.com";
        this.clave = "Asd1234a";
        this.roles = List.of(new RolTestDataBuilder().build());
    }

    public Usuario build() {
        return Usuario.crear(correo, clave, List.of(roles.get(0)));
    }
}