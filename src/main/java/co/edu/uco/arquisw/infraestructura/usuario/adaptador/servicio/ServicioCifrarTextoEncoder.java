package co.edu.uco.arquisw.infraestructura.usuario.adaptador.servicio;

import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioCifrarTexto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ServicioCifrarTextoEncoder implements ServicioCifrarTexto {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String ejecutar(String texto) {
        return passwordEncoder.encode(texto);
    }
}
