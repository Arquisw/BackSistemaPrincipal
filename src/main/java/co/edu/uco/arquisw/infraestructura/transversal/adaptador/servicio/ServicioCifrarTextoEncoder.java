package co.edu.uco.arquisw.infraestructura.transversal.adaptador.servicio;

import co.edu.uco.arquisw.dominio.transversal.servicio.ServicioCifrarTexto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ServicioCifrarTextoEncoder implements ServicioCifrarTexto {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String ejecutar(String clave) {
        return passwordEncoder.encode(clave);
    }

    @Override
    public boolean existe(String clave, String claveCifrada) {
        return passwordEncoder.matches(clave, claveCifrada);
    }
}
