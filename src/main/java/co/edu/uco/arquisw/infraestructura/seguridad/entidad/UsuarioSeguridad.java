package co.edu.uco.arquisw.infraestructura.seguridad.entidad;

import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioSeguridad implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = -6690946490872875352L;

    private final UsuarioDTO usuario;

    public UsuarioSeguridad(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        usuario.getPerfiles().forEach(perfil ->
        {
            authorities.add(new SimpleGrantedAuthority(perfil.getNombre()));
        });

        return authorities;
    }

    public int getId() {
        return usuario.getCodigo();
    }
    @Override
    public String getPassword() {
        return usuario.getClave();
    }

    @Override
    public String getUsername() {
        return usuario.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
