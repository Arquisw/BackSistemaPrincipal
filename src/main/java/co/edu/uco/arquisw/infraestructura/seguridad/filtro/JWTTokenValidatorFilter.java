package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.uco.arquisw.infraestructura.seguridad.constante.SecurityConstants;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
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
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String jwt1 = Jwts.builder().setIssuer("UCO").setSubject("JWT Token")
						.claim("username", authentication.getName())
						.claim("authorities", populateAuthorities(authentication.getAuthorities()))
						.setIssuedAt(new Date())
						.setExpiration(new Date((new Date()).getTime() + 30000000))
						.signWith(key1).compact();
				Claims claims2 = Jwts.parserBuilder()
						.setSigningKey(key1)
						.build()
						.parseClaimsJws(jwt1)
						.getBody();
				response.setHeader(SecurityConstants.JWT_HEADER, jwt1);
				String username = String.valueOf(claims2.get("username"));
				String authorities = (String) claims.get("authorities");
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
	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authoritiesSet = new HashSet<>();
		for (GrantedAuthority authority : collection) {
			authoritiesSet.add(authority.getAuthority());
		}
		return String.join(",", authoritiesSet);
	}
}