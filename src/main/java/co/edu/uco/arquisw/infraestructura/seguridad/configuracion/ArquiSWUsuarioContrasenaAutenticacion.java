package co.edu.uco.arquisw.infraestructura.seguridad.configuracion;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.aplicacion.servicio.usuario.ServicioAplicacionConsultarUsuarioPorCorreo;
import co.edu.uco.arquisw.infraestructura.seguridad.entidad.UsuarioSeguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArquiSWUsuarioContrasenaAutenticacion implements AuthenticationProvider
{
    private final ServicioAplicacionConsultarUsuarioPorCorreo servicioAplicacionConsultarUsuarioPorCorreo;

    private static final String AUTENTICACION_NO_SATISFACTIORIA = "No existe una entidad con el correo o clave ingresados";

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ArquiSWUsuarioContrasenaAutenticacion(ServicioAplicacionConsultarUsuarioPorCorreo servicioAplicacionConsultarUsuarioPorCorreo) {
        this.servicioAplicacionConsultarUsuarioPorCorreo = servicioAplicacionConsultarUsuarioPorCorreo;
    }

    @Override
    public Authentication authenticate(Authentication autenticacion) throws AuthenticationException {
        String correo = autenticacion.getName();
        String clave = autenticacion.getCredentials().toString();
        UsuarioDTO usuario = this.servicioAplicacionConsultarUsuarioPorCorreo.consultarPorCorreo(correo);
        if(usuario!=null){
            if(passwordEncoder.matches(clave,usuario.getClave())){
                UsuarioSeguridad usuarioSeguridad= new UsuarioSeguridad(usuario);
                return new UsernamePasswordAuthenticationToken(usuarioSeguridad,clave,getGrantedAuthorities(usuario.getPerfil()));
            }

            else {
                throw new IllegalArgumentException(AUTENTICACION_NO_SATISFACTIORIA);
            }
        }else {
            throw new IllegalArgumentException(AUTENTICACION_NO_SATISFACTIORIA);
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(PerfilDTO perfil) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getNombre()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> autenticacion) {
        return autenticacion.equals(UsernamePasswordAuthenticationToken.class);
    }
}
