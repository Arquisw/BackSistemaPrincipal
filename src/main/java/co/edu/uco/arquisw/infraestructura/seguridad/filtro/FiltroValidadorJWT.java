package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import co.edu.uco.arquisw.infraestructura.seguridad.constantes.Constantes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FiltroValidadorJWT extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader(Constantes.JWT_HEADER);

        if (null != jwt) {
            try {
                SecretKey llave = Keys.hmacShaKeyFor(Constantes.JWT_LLAVE.getBytes());
                Claims jwtInformacion = Jwts.parserBuilder().setSigningKey(llave).build().parseClaimsJws(jwt).getBody();
                String correo = String.valueOf(jwtInformacion.get("usuario"));
                String perfil = (String) jwtInformacion.get("perfil");
                Authentication auntenticacion = new UsernamePasswordAuthenticationToken(correo, null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(perfil));
                SecurityContextHolder.getContext().setAuthentication(auntenticacion);
            } catch (ExpiredJwtException ex) {
                throw new IllegalArgumentException(ex.getMessage());

            }catch (MalformedJwtException malformedJwtException){
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
            catch (Exception e) {
                response.sendError(403);
                throw new IllegalArgumentException(e.getMessage());
            }

        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().equals("/api/login");
    }
}
