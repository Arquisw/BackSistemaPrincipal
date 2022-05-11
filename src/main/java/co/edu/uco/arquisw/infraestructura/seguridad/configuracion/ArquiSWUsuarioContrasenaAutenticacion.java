package co.edu.uco.arquisw.infraestructura.seguridad.configuracion;

import co.edu.uco.arquisw.aplicacion.dto.PerfilDTO;
import co.edu.uco.arquisw.aplicacion.dto.UsuarioDTO;
import co.edu.uco.arquisw.aplicacion.servicio.usuario.ServicioAplicacionConsultarUsuarioPorCorreoConClave;
import co.edu.uco.arquisw.infraestructura.seguridad.entidad.UsuarioSeguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArquiSWUsuarioContrasenaAutenticacion implements AuthenticationProvider
{
    private final ServicioAplicacionConsultarUsuarioPorCorreoConClave servicioAplicacionConsultarUsuarioPorCorreoConClave;

    private static final String AUTENTICACION_NO_SATISFACTIORIA = "No existe una entidad con el correo o clave ingresados";

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ArquiSWUsuarioContrasenaAutenticacion(ServicioAplicacionConsultarUsuarioPorCorreoConClave servicioAplicacionConsultarUsuarioPorCorreoConClave)
    {
        this.servicioAplicacionConsultarUsuarioPorCorreoConClave = servicioAplicacionConsultarUsuarioPorCorreoConClave;
    }

    @Override
    public Authentication authenticate(Authentication autenticacion) throws AuthenticationException
    {
        String correo = autenticacion.getName();
        String clave = autenticacion.getCredentials().toString();
        UsuarioDTO usuario = this.servicioAplicacionConsultarUsuarioPorCorreoConClave.consultarPorCorreoConClave(correo);

        if(usuario!=null)
        {
            if(passwordEncoder.matches(clave,usuario.getClave()))
            {
                UsuarioSeguridad usuarioSeguridad= new UsuarioSeguridad(usuario);
                return new UsernamePasswordAuthenticationToken(usuarioSeguridad,clave,getGrantedAuthorities(usuario.getPerfiles()));
            }
            else
            {
                throw new IllegalArgumentException(AUTENTICACION_NO_SATISFACTIORIA);
            }
        }
        else
        {
            throw new IllegalArgumentException(AUTENTICACION_NO_SATISFACTIORIA);
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<PerfilDTO> perfiles)
    {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        perfiles.forEach(perfil ->
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getNombre()));
        });

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> autenticacion)
    {
        return autenticacion.equals(UsernamePasswordAuthenticationToken.class);
    }
}
