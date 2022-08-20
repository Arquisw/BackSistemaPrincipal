package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthoritiesLoggingAtFilter implements Filter {

	private final Logger LOG =
			Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("Se esta validando la autenticacion");
		chain.doFilter(request, response);
	}

}
