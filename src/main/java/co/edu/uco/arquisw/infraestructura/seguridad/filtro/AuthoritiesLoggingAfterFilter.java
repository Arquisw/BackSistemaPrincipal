package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
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

        if (!ValidarObjeto.esNulo(authentication)) {
            log.info(Mensajes.obtenerElUsuarioFueAutenticadoConExitoYTieneLosRoles(authentication.getName(), authentication.getAuthorities().toString()));
        }

        chain.doFilter(request, response);
    }
}