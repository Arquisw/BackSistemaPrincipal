package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAfterFilter implements Filter {
	private final Logger log = Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			log.info("El usuario " + authentication.getName() + " fue autenticado con exito " +
					" y tiene los roles " + authentication.getAuthorities().toString());
		}
		chain.doFilter(request, response);
	}
}