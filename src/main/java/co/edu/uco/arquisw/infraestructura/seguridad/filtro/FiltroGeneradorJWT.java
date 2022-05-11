package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import co.edu.uco.arquisw.infraestructura.seguridad.constantes.Constantes;
import co.edu.uco.arquisw.infraestructura.seguridad.entidad.UsuarioSeguridad;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FiltroGeneradorJWT extends OncePerRequestFilter
{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication&&authentication.getPrincipal() instanceof UsuarioSeguridad) {
            UsuarioSeguridad securityCustomer = (UsuarioSeguridad) authentication.getPrincipal();
            SecretKey key = Keys.hmacShaKeyFor(Constantes.JWT_LLAVE.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder().setIssuer("ArquiSW").setSubject("JWT Token")
                    .claim("usuario", authentication.getName())
                    .claim("perfil", populateAuthorities(authentication.getAuthorities()))
                    .claim("id", securityCustomer.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 7200000))
                    .signWith(key).compact();

            response.setHeader(Constantes.JWT_HEADER, jwt);

        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/api/login");
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }

}
