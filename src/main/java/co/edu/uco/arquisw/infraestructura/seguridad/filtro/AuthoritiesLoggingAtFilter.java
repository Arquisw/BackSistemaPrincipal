package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAtFilter implements Filter {
    private final Logger log = Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(Mensajes.SE_ESTA_VALIDANDO_LA_AUTENTICACION);
        chain.doFilter(request, response);
    }
}