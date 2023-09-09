package co.edu.uco.arquisw.infraestructura.transversal.adaptador.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioActualizarToken;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.infraestructura.seguridad.constante.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ServicioActualizarTokenJWT implements ServicioActualizarToken {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioActualizarTokenJWT(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    @Override
    public void ejecutar() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        validarSiExisteUsuarioConCorreo(username);
        SecretKey key1 = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        var persona = this.personaRepositorioConsulta.consultarUsuarioPorCorreo(username);
        String jwt1 = Jwts.builder().setIssuer("UCO").setSubject("JWT Token")
                .claim("username", persona.getCorreo())
                .claim("id", persona.getId())
                .claim("authorities", populateAuthorities(persona.getRoles()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 30000000))
                .signWith(key1).compact();
        Claims claims2 = Jwts.parserBuilder()
                .setSigningKey(key1)
                .build()
                .parseClaimsJws(jwt1)
                .getBody();
        response.setHeader(SecurityConstants.JWT_HEADER, jwt1);
        String authorities = (String) claims2.get("authorities");
        Authentication auth = new UsernamePasswordAuthenticationToken(username, null,
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private void validarSiExisteUsuarioConCorreo(String correo) {
        if (this.personaRepositorioConsulta.existeConCorreo(correo)) {
            throw new DuplicidadExcepcion(Mensajes.EXISTE_USUARIO_CON_CORREO + correo);
        }
    }

    private String populateAuthorities(List<RolDTO> authorities) {
        Set<String> authoritiesSet = new HashSet<>();
        for (RolDTO authority : authorities) {
            addCrudPrivilage(authoritiesSet, authority);
            authoritiesSet.add(authority.getNombre());
        }
        return String.join(",", authoritiesSet);
    }

    private void addCrudPrivilage(Set<String> grantedAuthorities, RolDTO authority) {
        if (authority.isLeer()) {
            grantedAuthorities.add(extractStringAfterUnderscore(authority.getNombre()) + "_" + TextoConstante.LECTURA);
        }
        if (authority.isEscribir()) {
            grantedAuthorities.add(extractStringAfterUnderscore(authority.getNombre()) + "_" + TextoConstante.ESCRITURA);
        }
        if (authority.isActualizar()) {
            grantedAuthorities.add(extractStringAfterUnderscore(authority.getNombre()) + "_" + TextoConstante.ACTUALIZACION);
        }
        if (authority.isActualizar()) {
            grantedAuthorities.add(extractStringAfterUnderscore(authority.getNombre()) + "_" + TextoConstante.ELIMINACION);
        }
    }

    private String extractStringAfterUnderscore(String input) {
        int index = input.indexOf('_');

        if (index != -1) {
            return input.substring(index + 1);
        } else {
            return "No underscore found.";
        }
    }
}