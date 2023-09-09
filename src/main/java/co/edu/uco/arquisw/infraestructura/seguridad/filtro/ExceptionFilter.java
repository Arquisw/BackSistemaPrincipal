package co.edu.uco.arquisw.infraestructura.seguridad.filtro;

import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionFilter extends OncePerRequestFilter {
    public ExceptionFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            ResponseEntity<co.edu.uco.arquisw.infraestructura.error.Error> error;
            int status = 500;
            if (ex instanceof BadCredentialsException) {
                status = 400;
            } else if (ex instanceof AutorizacionExcepcion) {
                status = 401;
            }

            response.setStatus(status);
            response.getWriter().write(ex.getLocalizedMessage());
        }
    }
}