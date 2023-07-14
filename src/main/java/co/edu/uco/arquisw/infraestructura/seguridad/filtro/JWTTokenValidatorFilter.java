package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorCorreo;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.infraestructura.seguridad.constante.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Component
public class JWTTokenValidatorFilter extends OncePerRequestFilter {
	@Autowired
	private ConsultarPersonaPorCorreo consultarPersonaPorCorreo;
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		consultarPersonaPorCorreo = WebApplicationContextUtils.
				getRequiredWebApplicationContext(request.getServletContext()).
				getBean(ConsultarPersonaPorCorreo.class);
		String jwt = request.getHeader(SecurityConstants.JWT_HEADER);

		if (jwt != null) {
			try {
				SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
				
				Claims claims = Jwts.parserBuilder()
						.setSigningKey(key)
						.build()
						.parseClaimsJws(jwt)
						.getBody();
				SecretKey key1 = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
				PersonaDTO persona= this.consultarPersonaPorCorreo.ejecutar(String.valueOf(claims.get("username")));

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
				String username = String.valueOf(claims.get("username"));
				String authorities = (String) claims2.get("authorities");
				Authentication auth = new UsernamePasswordAuthenticationToken(username,null,
						AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				SecurityContextHolder.getContext().setAuthentication(auth);
			}catch (Exception e) {
				throw new BadCredentialsException("El token recibido es invalido");
			}
		}
		chain.doFilter(request, response);
	}

	@Override protected boolean shouldNotFilter(HttpServletRequest request) {
	  return request.getServletPath().equals("/login");
	}
	private String populateAuthorities(List<RolDTO> authorities) {
		Set<String> authoritiesSet = new HashSet<>();
		for (RolDTO authority : authorities) {
			addCrudPrivilage(authoritiesSet,authority);
			authoritiesSet.add(authority.getNombre());
		}
		return String.join(",", authoritiesSet);
	}

	private void addCrudPrivilage(Set<String> grantedAuthorities, RolDTO authority){
		if(authority.isLeer())
		{
			grantedAuthorities.add(authority.getNombre()+"_"+ TextoConstante.LECTURA);
		}
		if(authority.isEscribir())
		{
			grantedAuthorities.add(authority.getNombre()+"_"+TextoConstante.ESCRITURA);
		}
		if(authority.isActualizar())
		{
			grantedAuthorities.add(authority.getNombre()+"_"+TextoConstante.ACTUALIZACION);
		}
		if(authority.isActualizar())
		{
			grantedAuthorities.add(authority.getNombre()+"_"+TextoConstante.ELIMINACION);
		}
	}
}