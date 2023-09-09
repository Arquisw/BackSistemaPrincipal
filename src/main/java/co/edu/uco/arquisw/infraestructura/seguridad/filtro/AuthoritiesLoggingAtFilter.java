package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAtFilter implements Filter {
    private final Logger log = Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Se esta validando la autenticacion");
        chain.doFilter(request, response);
    }
}